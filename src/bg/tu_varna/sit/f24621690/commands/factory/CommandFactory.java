package bg.tu_varna.sit.f24621690.commands.factory;

/**
 * Интерфейс за фабрики, създаващи команди.
 */
public interface CommandFactory {

    /**
     * Валидира входа и изпълнява съответната команда.
     *
     * @param args Масив от въведените думи в конзолата.
     * @return Съобщение с резултата от изпълнението.
     * @throws Exception При невалиден брой параметри или грешен формат на данните.
     */
    String execute(String[] args) throws Exception;
}