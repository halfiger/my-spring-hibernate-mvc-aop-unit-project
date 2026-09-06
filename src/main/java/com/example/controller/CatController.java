package com.example.controller;

import com.example.entity.Cat;
import com.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController (CatService catService) {
        this.catService = catService;
    }

    @GetMapping ("/cat-home")
    public String getAllCats (Model model) {
        List<Cat> cats = catService.getCats();
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping ("/cat-find")
    public String getCat (Model model, @RequestParam ("id") int id) {
        Cat cat = catService.getCat(id);
        model.addAttribute(cat);
        return "cat";
    }

    @GetMapping ("/cat-delete")
    public String deleteCat (@ModelAttribute("cat") Cat cat) {
        catService.deleteCat(cat);
        return "redirect:/cat-home";
    }

    @GetMapping ("/cat-save")
    public String saveCat (Model model) {
        Cat cat = new Cat();
        model.addAttribute("cat", cat);
        model.addAttribute("url", "/afterCatSave");
        return "cat-form";
    }

    @PostMapping ("/afterCatSave")
    public String afterCatSave (@ModelAttribute ("cat") Cat cat) {
        catService.saveCat(cat);
        return "redirect:/cat-find?id="+cat.getId();
    }

    @GetMapping ("/cat-update")
    public String updateCat (Model model, @RequestParam ("id") int id) {
        Cat cat = catService.getCat(id);
        model.addAttribute(cat);
        model.addAttribute("url", "/afterCatUpdate");
        return "cat-form";
    }

    @PostMapping ("/afterCatUpdate")
    public String afterCatUpdate (@ModelAttribute("cat") Cat cat) {
        catService.updateCat(cat);
        return "redirect:/cat-find?id="+cat.getId();
    }
}

/**
 * Так, тут уже видно конкретно, де ти промазав. І цього разу cats.jsp та GET-частина вже виглядають нормально.
 *
 * Проблема саме тут:
 *
 * @PostMapping (" / afterCatUpdate ")
 * public String afterCatUpdate (@RequestAttribute ("cat") Cat cat) {
 * Чому отримуєш 400
 *
 * Ти заходиш на:
 *
 * POST /mvc/afterCatUpdate
 *
 * Spring бачить:
 *
 * @RequestAttribute("cat")
 *
 * і каже приблизно:
 *
 * «Добре, дай мені cat із request attributes».
 *
 * Але твоя форма:
 *
 * <form:form
 *     action="${pageContext.request.contextPath}${url}"
 *     modelAttribute="cat"
 *     method="POST">
 *
 * надсилає поля форми як HTTP parameters:
 *
 * id=...
 * name=...
 * color=...
 * age=...
 *
 * Spring повинен створити Cat і заповнити його цими параметрами. Для цього потрібен @ModelAttribute, а не @RequestAttribute.
 *
 * Тобто:
 *
 * @PostMapping("/afterCatUpdate")
 * public String afterCatUpdate(@ModelAttribute("cat") Cat cat) {
 *     catService.updateCat(cat);
 *     return "redirect:/cat-find?id=" + cat.getId();
 * }
 * І ось тут дуже важлива різниця
 *
 * Ми фактично маємо три різні ситуації:
 *
 * 1. GET з ?id=5
 * /cat-find?id=5
 *
 * Тому:
 *
 * @RequestParam("id") int id
 *
 * Spring бере:
 *
 * id=5
 *    ↓
 * @RequestParam
 *    ↓
 * int id
 * 2. POST із HTML-форми
 *
 * Форма надсилає:
 *
 * id=5
 * name=Murzik
 * color=black
 * age=3
 *
 * Тому:
 *
 * @ModelAttribute("cat") Cat cat
 *
 * Spring робить приблизно:
 *
 * HTTP parameters
 *       ↓
 * створює Cat
 *       ↓
 * setId(5)
 * setName("Murzik")
 * setColor("black")
 * setAge(3)
 *       ↓
 * Cat cat
 *
 * Саме це тобі потрібно при update.
 *
 * 3. @RequestAttribute
 * @RequestAttribute("cat")
 *
 * Це зовсім інше.
 *
 * Він шукає щось, що вже було покладено в request attributes якимось попереднім механізмом:
 *
 * request.setAttribute("cat", cat);
 *
 * Твоя HTML-форма цього не робить.
 *
 * Тому Tomcat/Spring і повертає 400 Bad Request.
 *
 * Отже, зараз виправ тільки це
 * @PostMapping("/afterCatUpdate")
 * public String afterCatUpdate(@ModelAttribute("cat") Cat cat) {
 *     catService.updateCat(cat);
 *     return "redirect:/cat-find?id=" + cat.getId();
 * }
 *
 * І після цього перевір update.
 *
 * До речі, ти вже правильно зробив ось це:
 *
 * <form:hidden path="id"/>
 *
 * і в Cat у тебе є:
 *
 * public void setId(int id) {
 *     this.id = id;
 * }
 *
 * Це дуже важливо: ID тепер піде з форми назад у Cat, тому merge() матиме правильний ID і зможе оновити існуючого кота.
 *
 * Ще одна маленька помилка, яку побачимо після цього
 *
 * У cat.jsp:
 *
 * Cat name = ${cat.id}
 *
 * має бути:
 *
 * Cat name = ${cat.name}
 *
 * Але це не причина твого теперішнього 400.
 *
 * Тобто зараз ланцюжок update у тебе має бути:
 *
 * /cat-update?id=5
 *        ↓
 * getCat(5)
 *        ↓
 * Cat з id=5
 *        ↓
 * cat-form.jsp
 *        ↓
 * <form:hidden path="id">
 *        ↓
 * POST /afterCatUpdate
 *        ↓
 * @ModelAttribute("cat")
 *        ↓
 * Cat{id=5, ...}
 *        ↓
 * catService.updateCat(cat)
 *        ↓
 * DAO.merge(cat)
 *        ↓
 * redirect:/cat-find?id=5
 *
 * Ось цей @RequestAttribute → @ModelAttribute зараз є головною помилкою.
 *
 * є дуже важливий нюанс: ти не передаєш Cat як Java-об'єкт через HTML. JSP-форма передає значення полів, а Spring вже збирає з них Java-об'єкт.
 *
 * Саме тут, думаю, і виникла плутанина.
 *
 * Що відбувається у твоєму cat-form.jsp
 *
 * Ти маєш:
 *
 * <form:form modelAttribute="cat" method="POST">
 *
 *     <form:hidden path="id"/>
 *     <form:input path="name"/>
 *     <form:input path="color"/>
 *     <form:input path="age"/>
 *
 * </form:form>
 *
 * У тебе в Java є:
 *
 * Cat cat
 *
 * Але браузер не знає, що таке Java-клас Cat.
 *
 * Він відправить приблизно:
 *
 * id=5
 * name=Murzik
 * color=black
 * age=3
 *
 * Тобто на HTTP-рівні це просто параметри.
 *
 * А ось тут:
 *
 * @PostMapping("/afterCatUpdate")
 * public String afterCatUpdate(@ModelAttribute("cat") Cat cat)
 *
 * Spring каже:
 *
 * Візьми параметри запиту id, name, color, age і створи з них об'єкт Cat, використовуючи його setters.
 *
 * Умовно:
 *
 * Cat cat = new Cat();
 *
 * cat.setId(5);
 * cat.setName("Murzik");
 * cat.setColor("black");
 * cat.setAge(3);
 *
 * І вже потім ти отримуєш:
 *
 * catService.updateCat(cat);
 * А чому в тебе не працював @RequestAttribute?
 *
 * Ти написав:
 *
 * @PostMapping("/afterCatUpdate")
 * public String afterCatUpdate(@RequestAttribute("cat") Cat cat)
 *
 * @RequestAttribute означає зовсім інше:
 *
 * Знайди вже існуючий об'єкт cat, який хтось поклав саме в request attributes.
 *
 * А твоя JSP-форма такого не робить.
 *
 * Тому:
 *
 * <form>
 *      ↓
 * id=5
 * name=Murzik
 * color=black
 * age=3
 *      ↓
 * HTTP request parameters
 *      ↓
 * @ModelAttribute
 *      ↓
 * Cat object
 *
 * Ось це твоя схема.
 *
 * І тепер цікава річ із твоїм id
 *
 * Ти кажеш:
 *
 * «я пробував передавати об'єкти, але вийшло чомусь що я передав id»
 *
 * Насправді ти й не можеш передати Java-об'єкт через звичайний HTML request.
 *
 * Коли ти робиш:
 *
 * <a href="/cat-find?id=${cat.id}">
 *
 * ти явно передаєш тільки ID:
 *
 * ?id=5
 *
 * і тому контролер:
 *
 * @RequestParam("id") int id
 *
 * отримує 5.
 *
 * Потім уже сервер робить:
 *
 * Cat cat = catService.getCat(id);
 *
 * А коли ти робиш форму:
 *
 * <form:hidden path="id"/>
 * <form:input path="name"/>
 * <form:input path="color"/>
 * <form:input path="age"/>
 *
 * ти передаєш усі необхідні дані об'єкта, просто не як об'єкт:
 *
 * id=5
 * name=Murzik
 * color=black
 * age=3
 *
 * і:
 *
 * @ModelAttribute("cat") Cat cat
 *
 * збирає їх назад у Cat.
 *
 * Тому запам'ятай дуже просте правило:
 * Що приходить	Що використовуємо
 * ?id=5	@RequestParam("id")
 * Дані HTML-форми → Java-об'єкт	@ModelAttribute("cat")
 * Уже покладений у request атрибут Java-об'єкт	@RequestAttribute("cat")
 *
 * Для твоїх Spring MVC JSP-форм @ModelAttribute — саме те, що тобі потрібно.
 *
 * І ще важливий момент: modelAttribute="cat" у JSP і @ModelAttribute("cat") у controller — це не випадковий збіг.
 * Вони пов'язані одним ім'ям cat. Це як «ім'я контейнера», під яким Spring працює з твоїм об'єктом.
 */