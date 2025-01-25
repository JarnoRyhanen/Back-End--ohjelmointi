package backend.model_view.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import backend.model_view.domain.Friend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendController {

    private List<Friend> friends = new ArrayList<>();

 
    @GetMapping("/friends")
    public String showFriends(Model model) {
        model.addAttribute("friend", new Friend());
        model.addAttribute("friends", friends);
        return "friends";
    }

    @PostMapping("/friends")
    public String addFriend(@ModelAttribute Friend friend, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("friends", friends);
            return "friends";
        }
        friends.add(friend);
        return "redirect:/friends";
    }
}