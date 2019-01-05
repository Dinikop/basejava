package org.dnk;

import org.dnk.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.dnk.model.ContactType.*;
import static org.dnk.model.SectionType.*;
import static org.dnk.util.DateUtil.of;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        fillAllFields(resume, 0);
    }

    public static void fillInResumes(Resume... resumes) {
        for (int i = 0; i < resumes.length; i++) {
            fillAllFields(resumes[i], i);
        }
    }

    private static void fillEducation(Resume resume, int id) {
        List<Place> educationPlaces = new ArrayList<>();

        List<Position> positions1 = new ArrayList<>();
        positions1.add(new Position(of(2010, id + 1), of(2010, id + 2), addId("education 1 title position1", id), null));
        positions1.add(new Position(of(2010, id + 3), of(2010, id + 4), addId("education 1 title position2", id), null));
        educationPlaces.add(new Place(addId("education place1", id), addId("https://www.education1.com/", id), positions1));

        List<Position> positions2 = new ArrayList<>();
        positions1.add(new Position(of(2011, id + 1), of(2011, id + 2), addId("education 2 title position", id), null));
        educationPlaces.add(new Place(addId("education place2", id), addId("https://www.education2.com/", id), positions2));

        AbstractSection education = new PlaceSection(educationPlaces);
        resume.addSection(EDUCATION, education);
    }

    private static void fillExperience(Resume resume, int id) {
        List<Place> experiencePlaces = new ArrayList<>();
        List<Position> positions = new ArrayList<>();

        positions.add(new Position(of(2012, id + 1), LocalDate.now(), addId("experience title", id), addId("experience description", id)));
        experiencePlaces.add(new Place(addId("experience name", id), addId("http://experience.ru/", id), positions));

        AbstractSection experience = new PlaceSection(experiencePlaces);
        resume.addSection(EXPERIENCE, experience);
    }

    private static void fillQualification(Resume resume, int id) {
        List<String> qualificationList = new ArrayList<>();
        qualificationList.add(addId("qualification1", id));
        qualificationList.add(addId("qualification2", id));
        resume.addSection(QUALIFICATIONS, new ListSection(qualificationList));
    }

    private static void fillContacts(Resume resume, int id) {
        resume.addContact(PHONE, addId("+7(921) 855-0482", id));
        resume.addContact(SKYPE, addId("grigory.kislin", id));
        resume.addContact(MAIL, addId("gkislin@yandex.ru", id));
    }

    private static void fillObjective(Resume resume, int id) {
        resume.addSection(OBJECTIVE, new TextSection(addId("objective description ", id)));
    }

    private static void fillPersonal(Resume resume, int id) {
        resume.addSection(PERSONAL, new TextSection(addId("personal description ", id)));
    }

    private static void fillAchievement(Resume resume, int id) {
        List<String> achievementList = new ArrayList<>();
        achievementList.add(addId("achivement1", id));
        achievementList.add(addId("achivement2", id));
        AbstractSection achievement = new ListSection(achievementList);
        resume.addSection(ACHIEVEMENT, achievement);
    }

    private static String addId(String string, int id) {
        return string + " " + "id-" + id;
    }

    private static void fillAllFields(Resume resume, int id) {
        fillContacts(resume, id);
        fillObjective(resume, id);
        fillPersonal(resume, id);
        fillAchievement(resume, id);
        fillQualification(resume, id);
        fillExperience(resume, id);
        fillEducation(resume, id);
    }
}
