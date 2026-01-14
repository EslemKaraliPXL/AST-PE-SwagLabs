package testObjects;

public interface ILoginObject extends IBaseObject {
    void login(String username, String password);

    boolean isLoaded();
    boolean isErrorDisplayed();
}
