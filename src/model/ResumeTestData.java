package model;

import java.util.ArrayList;
import java.util.List;

import static model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        fillContacts(resume);
        fillObjective(resume);
        fillPersonal(resume);
        fillAchievement(resume);
        fillQalification(resume);
        fillExperience(resume);
        fillEducation(resume);

        System.out.println(resume);
    }

    private static void fillEducation(Resume resume) {
        List<Place> educationPlaces = new ArrayList<>();
        educationPlaces.add(new Place("Coursera", "03/2013", "05/2013",
                "Functional Programming Principles in Scala by Martin Odersky", ""));
        educationPlaces.add(new Place("Luxoft", "03/2011", "04/2011",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", ""));
        Section education = new PlaceSection(educationPlaces);
        resume.addSection(EDUCATION, education);
    }

    private static void fillExperience(Resume resume) {
        List<Place> experiencePlaces = new ArrayList<>();
        experiencePlaces.add(new Place("Java Online Projects", "10/2013", "Сейчас",
                "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experiencePlaces.add(new Place("Wrike", "10/2014", "01/2016", "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами"));
        Section experience = new PlaceSection(experiencePlaces);
        resume.addSection(EXPERIENCE, experience);
    }

    private static void fillQalification(Resume resume) {
        List<String> qualificationList = new ArrayList<>();
        qualificationList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        Section qualification = new ListSection(qualificationList);
        resume.addSection(QUALIFICATIONS, qualification);
    }

    private static void fillContacts(Resume resume) {
        resume.addContact("Тел", "+7(921) 855-0482");
        resume.addContact("Skype", "grigory.kislin");
        resume.addContact("mail", "gkislin@yandex.ru");
    }

    private static void fillObjective(Resume resume) {
        Section objective = new StringSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(OBJECTIVE, objective);
    }

    private static void fillPersonal(Resume resume) {
        Section personal = new StringSection("Аналитический склад ума, сильная логика, креативность");
        resume.addSection(PERSONAL, personal);
    }

    private static void fillAchievement(Resume resume) {
        List<String> achievementList = new ArrayList<>();
        achievementList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"");
        achievementList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike.");
        Section achievement = new ListSection(achievementList);
        resume.addSection(ACHIEVEMENT, achievement);
    }
}
