package com.example.firstproject.myController;

import com.example.firstproject.myDto.FKoreaForm;
import com.example.firstproject.myEntity.FKorea;
import com.example.firstproject.myRepository.FKoreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FKoreaController {
    @Autowired
   private  FKoreaRepository fkoreaRepository;

    //첫화면
    @GetMapping("/FromKorea/apply")
    public String home(){
        return "FromKorea/apply";
    }

    //create
    @PostMapping ("/FromKorea/create")
    public String createFK(FKoreaForm form){
        //1. DTO를 Entity로 변환
        FKorea fkorea = form.toEntity();

        //2. Repository에게 Entity를 DB안에 저장하게 함
        FKorea saveok = fkoreaRepository.save(fkorea);
        return "redirect:/FromKorea/" + saveok.getSeq();
    }

    //Read(하나씩 세부내용)
    @GetMapping("/FromKorea/{seq}")
    public String detail(@PathVariable Long seq, Model m){
        //1. ID로 데이터 가져오기(Eneity타입으로 해야 repository랑 소통 가능)
        FKorea fkoreaEntity = fkoreaRepository.findById(seq).orElse(null);

        //2. 가져온 데이터를 view에 보여주기 위해 모델에 등록
        m.addAttribute("fkorea", fkoreaEntity);

        //3. 보여줄 페이지 설정
        return "/FromKorea/detail";
    }

    //Read (List로 여러개 모아보기)
    @GetMapping("/FromKorea")
    public String colletion(Model m){
        List<FKorea> fKoreaList = fkoreaRepository.findAll();
        m.addAttribute("collection", fKoreaList);
        return "/FromKorea/home";
    }



}
