package com.training.cleancode.e20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class NameInverter {

    private static final Pattern HONORIFICS = Pattern.compile("Mr\\.||Mis\\.");
    private List<String> nameParts;


    public String invert(String name) {
        if (isEmpty(name))
            return "";

        initialNameParts(name);
        removeHonorifics();
        return formatInvertName();
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private void initialNameParts(String name) {
        nameParts = new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }

    private void removeHonorifics() {
        if (HONORIFICS.matcher(nameParts.get(0)).matches())
            nameParts.remove(0);
    }

    private String formatInvertName() {
        if (nameParts.size() == 1)
            return nameParts.get(0);

        String lastName = nameParts.get(1);
        String firstName = nameParts.get(0);
        String postNominals = getPostNominals();
        return String.format("%s, %s %s", lastName, firstName, postNominals).trim();
    }

    private String getPostNominals() {
        StringBuilder postNominals = new StringBuilder();
        if (nameParts.size() > 2)
            for (int i = 2; i < nameParts.size(); i++)
                postNominals.append(nameParts.get(i)).append(" ");

        return postNominals.toString();
    }
}