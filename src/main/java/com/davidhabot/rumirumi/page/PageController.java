package com.davidhabot.rumirumi.page;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     <b>해당 게임에 존재하는 모든 페이지를 조작하는 컨트롤러</b>
 * </p>
 * 현재 페이지를 및, 존재하는 모든 페이지를 저장한다.
 * 이후 페이지의 인덱스를 통해서 현재 페이지를 토글하거나,
 * 페이지를 보이거나 숨기게 할 수 있다.
 *
 * @author DavidHavot
 * @version 1.0
 * @since 1.0
 * <pre> {@code
 *     PageController controller = PageController.getInstance();
 *     controller.showPage();
 * } </pre>
 */
public class PageController extends JFrame {
    private List<Page> allPage;
    private Page currentPage; //현재 PageController 가 화면에 포시하고있는 페이지
    private Dimension size; //해당 게임 창의 사이즈

    private PageController(Page firstPage) { //싱글톤 패턴을 위한 PageController 의 private 생성자
        allPage = new ArrayList<>();
        currentPage = firstPage; //현재 페이지를 매개변수로 받은 firstPage 로 초기화한다.
        size = new Dimension(1920, 1080); //페이지의 크기를 결정한다.
        setFocusable(true);
        //FHD 사이즈로 사이즈를 고정한다.
        setSize(size); //사이즈를 size 에 담긴 FHD 사이즈로 조정한다.
        setResizable(false); //유저가 사이즈를 조종하지 못하게 한다.
    }

    private static class Controller { //싱글톤 패턴을 위한 inner class
        //싱클톤 인스턴스를 instance 라는 클래스 로딩시점에서 초기화되는 PageController 객체에 저장한다
        //TODO 2020.12.18 | error handling | DavidHabot
        private static final PageController instance = new PageController(PageFactory.getStartPage());
    }

    public static PageController getInstance() { //싱글톤 인스턴스를 반환한다.
        return Controller.instance; //static 클래스인 Controller 에서 instance 를 가져와 반환한다.
    }

    public void showPage() { //해당 JFrame을 화면에 띄운다
        if(!isVisible()) //만약 JFrame이 화면에 띄워져있지 않을경우,
            setVisible(true); //JFrame 의 setVisible 메서드를 사용한다.
    }

    public void hidePage() { //해당 프레임을 화면에서 숨긴다.
        if(isVisible()) //만약 JFrame이 화면에 띄워져있을경우,
            setVisible(false); //JFrame 의 setVisible 메서드를 사용한다.
    }

    public void togglePage(Page page) { //페이지를 매개변수를 받아, JFrame 의 컴포넌트(예상값 : Page)를 초기화한다.
        removeAll(); //JFrame 에 있는 모든 컴포넌트를 삭제한다.
        //JFrame 에 매개변수로 받은 Page 를 currentPage 에 담은 후, 이를 출력시킨다.
        this.currentPage = page; //currentPage 에 page 를 대입한다.
        add(currentPage); //currentPage 를 PageController 에 컴포넌트로서 추가한다.
    }
}
