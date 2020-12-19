package com.davidhabot.rumirumi.page;

/**
 * <p>
 *     <b>게임 내 존재하는 페이지들을 생성하고, 반환하는 클래스</b>
 * </p>
 * 페이지 종류에따라 계속 getter 를 생성하여 페이지를 반환한다.
 * 페이지 내의 컨테이너는 해당 페이지 클래스에 내장되어있다.
 *
 * @author DavidHavot
 * @version 1.0
 * @since 1.0
 * <pre> {@code
 *     Page page = PageFactory.getEmptyPage();
 * } </pre>
 */
public class PageFactory {
    public static Page getEmptyPage() { //빈 페이지를 반환하는 펙토링 메서드
        return new Page() {}; //빈 페이지를 새로 생성하여 반환한다.
    }

    public static Page getStartPage() { //처음 시작할때 페이지를 반환한다.
        return new Page() {}; //아직 스타트 페이지를 어떻게 설정할지 모르므로 빈채로 놔둔다.
        //TODO 2020.12.18 | 추후 getLoadPage 의 반환값을 반환할 예정 | DavidHabot
    }
}
