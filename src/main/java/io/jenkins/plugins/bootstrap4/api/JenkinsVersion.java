package io.jenkins.plugins.bootstrap4.api;

import hudson.util.VersionNumber;

public class JenkinsVersion {

    public static JenkinsVersion get() {
        return new JenkinsVersion();
    }

    public boolean isNewerThanOrEqualTo(String current, String target) {
        return new VersionNumber(current).isNewerThanOrEqualTo(new VersionNumber(target));
    }

}
