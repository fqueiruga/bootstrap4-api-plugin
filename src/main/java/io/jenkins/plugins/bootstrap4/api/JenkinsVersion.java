package io.jenkins.plugins.bootstrap4.api;

import hudson.util.VersionNumber;

public class JenkinsVersion {

    public static boolean isNewerThanOrEqualTo(String current, String target) {
        return new VersionNumber(current).isNewerThanOrEqualTo(new VersionNumber(target));
    }

}
