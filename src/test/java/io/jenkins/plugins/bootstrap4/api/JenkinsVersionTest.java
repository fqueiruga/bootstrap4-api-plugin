package io.jenkins.plugins.bootstrap4.api;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JenkinsVersionTest {

    @Test
    public void isNewerThanOrEqualTo() {
        String current = "2.221.3-SNAPSHOT";
        assertTrue("Is true for the same version", JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.221"));
        assertTrue("Is true for a lower version", JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.204"));
        assertFalse("Is false for a higher version", JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.235"));
    }

    @Test
    public void detectsVersionsInManyNamingSchemes() {
        String current = "2.235";
        assertTrue(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.235"));
        assertFalse(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.236.1-SNAPSHOT"));

        current = "2.235.2";
        assertTrue(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.235"));
        assertFalse(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.236.1-SNAPSHOT"));

        current = "2.235.2.1";
        assertTrue(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.235"));
        assertFalse(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.236.1-SNAPSHOT"));

        current = "2.235.2-rc123-next-SNAPSHOT";
        assertTrue(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.235"));
        assertFalse(JenkinsVersion.get().isNewerThanOrEqualTo(current, "2.236.1-SNAPSHOT"));
    }

}
