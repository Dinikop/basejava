import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static model.ContactType.*;
import static model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        fillContacts(resume);
        fillObjective(resume);
        fillPersonal(resume);
        fillAchievement(resume);
        fillQualification(resume);
        fillExperience(resume);
        fillEducation(resume);

        System.out.println(resume);
    }

    private static void fillEducation(Resume resume) {
        List<Place> educationPlaces = new ArrayList<>();
        educationPlaces.add(new Place("Coursera", "https://www.coursera.org/course/progfun",
                LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "Functional Programming Principles in Scala by Martin Odersky", null));
        educationPlaces.add(new Place("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null));
        AbstractSection education = new PlaceSection(educationPlaces);
        resume.addSection(EDUCATION, education);
    }

    private static void fillExperience(Resume resume) {
        List<Place> experiencePlaces = new ArrayList<>();
        experiencePlaces.add(new Place("Java Online Projects", "http://javaops.ru/",
                LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experiencePlaces.add(new Place("Wrike", "https://www.wrike.com/", LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 01, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike"));
        AbstractSection experience = new PlaceSection(experiencePlaces);
        resume.addSection(EXPERIENCE, experience);
    }

    private static void fillQualification(Resume resume) {
        List<String> qualificationList = new ArrayList<>();
        qualificationList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        AbstractSection qualification = new ListSection(qualificationList);
        resume.addSection(QUALIFICATIONS, qualification);
    }

    private static void fillContacts(Resume resume) {
        resume.addContact(PHONE, "+7(921) 855-0482");
        resume.addContact(SKYPE, "grigory.kislin");
        resume.addContact(MAIL, "gkislin@yandex.ru");
    }

    private static void fillObjective(Resume resume) {
        AbstractSection objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(OBJECTIVE, objective);
    }

    private static void fillPersonal(Resume resume) {
        AbstractSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность");
        resume.addSection(PERSONAL, personal);
    }

    private static void fillAchievement(Resume resume) {
        List<String> achievementList = new ArrayList<>();
        achievementList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"");
        achievementList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike.");
        AbstractSection achievement = new ListSection(achievementList);
        resume.addSection(ACHIEVEMENT, achievement);
    }
}
