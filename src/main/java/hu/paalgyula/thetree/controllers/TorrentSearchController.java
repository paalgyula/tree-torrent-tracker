package hu.paalgyula.thetree.controllers;

import hu.paalgyula.thetree.dao.TorrentsDAO;
import hu.paalgyula.thetree.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TorrentSearchController {
    @Autowired private TorrentsDAO torrentsDAO;

    @ModelAttribute("user")
    public Users getUser() {
        return (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping(value = "/letoltes.tt")
    public String torrentList(
            @RequestParam(value = "p", required = false, defaultValue = "1")Integer page,
            Model model
    ) {
        model.addAttribute( "page", page );
        model.addAttribute( "torrents", torrentsDAO.list() );
        model.addAttribute( "count", torrentsDAO.resultCount("", "", "") );
        return "torrents.list";
    }

    @RequestMapping(value = "/letoltes.tt/{field}-{direction}")
    public String searchTorrent(
            @RequestParam(value = "p", required = false, defaultValue = "1")Integer page,
            @PathVariable("field") String field,
            @PathVariable("direction") String direction, Model model
    ) {
        //: [name|uploaded|size|downloads|seeders|leechers]
        model.addAttribute( "page", page );
        model.addAttribute( "torrents", torrentsDAO.search( field, direction, "", page ) );
        model.addAttribute( "count", torrentsDAO.resultCount(field, direction, "") );
        return "torrents.list";
    }

    @RequestMapping(value = "/letoltes.tt/{field}-{direction}/{searchString}")
    public String searchTorrent(
            @RequestParam(value = "p", required = false, defaultValue = "1")Integer page,
            @PathVariable String field,
            @PathVariable String direction,
            @PathVariable String searchString,
            Model model
    ) {
        //: [name|uploaded|size|downloads|seeders|leechers]
        model.addAttribute( "page", page );
        model.addAttribute( "torrents", torrentsDAO.search( field, direction, searchString, page ) );
        model.addAttribute( "count", torrentsDAO.resultCount(field, direction, searchString) );
        return "torrents.list";
    }
}
