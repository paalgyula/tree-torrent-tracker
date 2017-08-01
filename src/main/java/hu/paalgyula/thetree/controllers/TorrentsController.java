package hu.paalgyula.thetree.controllers;

import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.repositories.TorrentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class TorrentsController {

    @Autowired
    private TorrentRepository torrentRepository;

    @ModelAttribute("torrents")
    public List<Torrent> torrentList() {
//        PageRequest request = new PageRequest(1,
//                10,
//                new Sort(Sort.Direction.DESC, "id")
//                        .and(new Sort(Sort.Direction.ASC, "name"))
//        );

        return torrentRepository.findAll();
    }

    @GetMapping("/torrents")
    public String torrentsPage(Model model) {
        //model.addAttribute( "torrents", torrentRepository.findAll(request) );

        return "torrents/search";
    }
}
