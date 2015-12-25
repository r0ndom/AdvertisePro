package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.model.User;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationService {
    private static final Pattern login = Pattern.compile("^[a-zA-Z][a-zA-Z_\\-0-9]{5,19}$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern email = Pattern.compile("^[\\w0-9_\\-\\.]+@[\\w\\-]+\\.\\w{2,5}$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern password = Pattern.compile("^[\\w0-9]{6,20}$", Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern name = Pattern.compile("^[А-Я][а-я]+$", Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern city_street = Pattern.compile("^[А-Я][а-яё]+$", Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern house_flat = Pattern.compile("^[0-9]{1,3}[А-Яа-я]?$", Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern postCode = Pattern.compile("^[0-9]{5}$", Pattern.MULTILINE | Pattern.UNICODE_CASE);
    private static final Pattern phone = Pattern.compile("^\\+[0-9]{2}\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}$", Pattern.MULTILINE | Pattern.UNICODE_CASE);

    public String checkFormRegistrationData(User user) {
        if (user.getCredentials().getLogin() != null && !checkLogin(user.getCredentials().getLogin())) return "Ошибка! Неверный формат логина! Логин должен иметь длину от 6 до 20 символов и состоять из латинских букв, цифр, символов подчеркивания и тире, а также начинаться с буквы!";
        if (!checkEmail(user.getContacts().getEmail())) return "Ошибка! Неверный формат email! Email должен иметь один из следующих форматов: a@asd.com, test@mail.ru, asda_sd@asd.info";
        if (!user.getCredentials().getPassword().equals(user.getCredentials().getSecondPassword())) return "Ошибка! Пароли не совпадают!";
        if (!checkPassword(user.getCredentials().getPassword())) return "Ошибка! Неверный формат пароля! Пароль должен содержать символы латинского алфавита и цифры, а также иметь длину от 6 до 20 символов";
        if (!checkName(user.getLastName())) return "Ошибка! Неверный формат фамилии!";
        if (!checkName(user.getFirstName())) return "Ошибка! Неверный формат имени!";
        if (!checkName(user.getMiddleName())) return "Ошибка! Неверный формат отчества!";
        if (!checkCityOrStreet(user.getContacts().getCity())) return "Ошибка! Неверный формат города!";
        if (!checkCityOrStreet(user.getContacts().getStreet())) return "Ошибка! Неверный формат улицы!";
        if (!checkHouseFlat(user.getContacts().getHouse())) return "Ошибка! Неверный формат номера дома! Номер дома должен содержать от 1 до 3 цифр и возможно заканчиваться на букву!";
        if (!checkHouseFlat(user.getContacts().getFlat())) return "Ошибка! Неверный формат номера квартиры! Номер квартиры должен содержать от 1 до 3 цифр и возможно заканчиваться на букву!";
        if (!checkPostCode(user.getContacts().getPostCode())) return "Ошибка! Неверный формат почтового индекса! Почтовый индекс должен содержать 5 цифр!";
        if (!checkPhone(user.getContacts().getPhone())) return "Ошибка! Неверный формат номера телефона! Пример ввода номера телефона: +38(096)112-43-12";
        return null;
    }

    private boolean checkLogin(String login) {
        Matcher loginMatcher = RegistrationService.login.matcher(login);
        return loginMatcher.matches();
    }

    private boolean checkEmail(String email) {
        Matcher emailMatcher = RegistrationService.email.matcher(email);
        return emailMatcher.matches();
    }

    private boolean checkPassword(String password) {
        Matcher passwordMatcher = RegistrationService.password.matcher(password);
        return passwordMatcher.matches();
    }

    private boolean checkName(String name) {
        Matcher nameMatcher = RegistrationService.name.matcher(name);
        return nameMatcher.matches();
    }

    private boolean checkCityOrStreet(String city_street) {
        Matcher city_streetMatcher = RegistrationService.city_street.matcher(city_street);
        return city_streetMatcher.matches();
    }

    private boolean checkHouseFlat(String house_flat) {
        Matcher house_flatMatcher = RegistrationService.house_flat.matcher(house_flat);
        return house_flatMatcher.matches();
    }

    private boolean checkPostCode(int postCode) {
        Matcher postCodeMatcher = RegistrationService.postCode.matcher(String.valueOf(postCode));
        return postCodeMatcher.matches();
    }

    private boolean checkPhone(String phone) {
        Matcher phoneMatcher = RegistrationService.phone.matcher(phone);
        return phoneMatcher.matches();
    }
}