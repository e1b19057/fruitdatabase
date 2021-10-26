package oit.is.fruit.kaizi.fruitdatabase.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.fruit.kaizi.fruitdatabase.model.Fruit;
import oit.is.fruit.kaizi.fruitdatabase.model.FruitMapper;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  @Autowired
  FruitMapper fMapper;

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }

  @GetMapping("step2")
  public String sample52(ModelMap model) {
    ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
    model.addAttribute("fruits2", fruits2);
    return "sample51.html";
  }

  @GetMapping("step3")
  @Transactional
  public String sample53(@RequestParam Integer id, ModelMap model) {
    // 削除対象のフルーツを取得
    Fruit fruit3 = fMapper.selectById(id);
    model.addAttribute("fruit3", fruit3);

    // 削除
    fMapper.deleteById(id);

    // 削除後のフルーツリストを取得
    ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
    model.addAttribute("fruits2", fruits2);
    return "sample51.html";
  }
}
