package com.learning.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class BrowserHistory {
    public Stack<String> history_back;
    public Stack<String> history_forward;

    public String current;

    public BrowserHistory(String homepage) {
        this.history_back = new Stack<>();
        this.history_back.push(homepage);
        this.current = homepage;
    }

    public void visit(String url) {
        this.history_forward = new Stack<>();

        this.history_back.push(url);
        this.current = url;
    }

    public String back(int steps) {
        while (--steps >= 0 && !this.history_back.isEmpty()) {
            this.history_forward.push(this.current);
            this.current = this.history_back.pop();
        }

        return this.current;
    }

    public String forward(int steps) {
        while (--steps >= 0 && !this.history_forward.isEmpty()) {
            this.history_back.push(this.current);
            this.current = this.history_forward.pop();
        }
        return this.current;
    }

    public static void main(String[] args) {

        //String[] actions = {"BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"};
//        String[][] urls = {{"leetcode.com"},{"google.com"},{"facebook.com"},{"youtube.com"},{"1"},{"1"},{"1"},{"linkedin.com"},
//                {"2"},{"2"},{"7"}};

        String[] actions = {"BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"};
        String[][] urls = {{"leetcode.com"},{"google.com"},{"facebook.com"},{"youtube.com"},{"1"},{"1"},{"1"},{"linkedin.com"},
                {"2"},{"2"},{"7"}};
        String[] ans = new String[actions.length];
        BrowserHistory browserHistory = null;

        for (int i = 0; i < actions.length; i++){
            String action = actions[i];


            if (action.equalsIgnoreCase("BrowserHistory")) {
                // initialize the browser history with corresponding home page
                 browserHistory = new BrowserHistory(urls[i][0]);
                ans[i] = null;
            } else if (action.equalsIgnoreCase("visit")) {
                browserHistory.visit(urls[i][0]);
                ans[i] = null;
            } else if (action.equalsIgnoreCase("back")) {
                int steps = Integer.parseInt(urls[i][0]);
                String backUrl = browserHistory.back(steps);
                ans[i] = backUrl;
            } else if (action.equalsIgnoreCase("forward")) {
                int steps = Integer.parseInt(urls[i][0]);
                String forwardUrl = browserHistory.forward(steps);
                ans[i] = forwardUrl;
            }
        }


        System.out.println(Arrays.toString(ans));
    //[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

    }


}
