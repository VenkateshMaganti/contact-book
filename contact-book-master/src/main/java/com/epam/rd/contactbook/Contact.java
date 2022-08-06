package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private ContactInfo personName;
    private ContactInfo contactNumber;
    private Email[] emailAddresses;
    private Social[] socialMediaAccounts;
    private int emailAddressPointer;
    private int socialMediaPointer;

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return Contact.this.contactName;
        }

        @Override
        public String toString() {
            return this.getTitle() + " : " + this.getValue();
        }
    }

    public static class Email implements ContactInfo {
        private String value;

        public Email(String value) {
            super();
            this.value = value;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.getTitle() + " : " + this.getValue();
        }
    }

    public static class Social implements ContactInfo {
        private String title;
        private String value;

        public Social(String title, String value) {
            super();
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.getTitle() + " : " + this.getValue();
        }
    }

    public Contact(String contactName) {
        //Implement this method
        this.contactName = contactName;
        this.personName = this.new NameContactInfo();
        this.emailAddresses = new Contact.Email[3];
        this.socialMediaAccounts = new Contact.Social[5];
        this.emailAddressPointer = 0;
        this.socialMediaPointer = 0;
    }

    public void rename(String newName) {
        //Implement this method
        if (newName != null && !newName.trim().equals("")) {
            Contact.this.contactName = newName;
        }

    }

    public Email addEmail(String localPart, String domain) {
        //Implement this method
        if (this.emailAddressPointer < 3) {
            Email email = new Email(localPart + "@" + domain);
            this.emailAddresses[this.emailAddressPointer++] = email;
            return email;
        } else {
            return null;
        }

    }


    public Email addEpamEmail(String firstname, String lastname) {
        //Implement this method
        if (this.emailAddressPointer < 3) {
            Email email = new Email(firstname + "_" + lastname + "@epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            this.emailAddresses[this.emailAddressPointer++] = email;
            return email;
        } else {
            return null;
        }

    }

    public ContactInfo addPhoneNumber(int code, String number) {
        //Implement this method
        if (this.contactNumber == null) {
            ContactInfo contactInfo = new ContactInfo() {
                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }

                @Override
                public String getTitle() {
                    return "Tel";
                }
            };
            this.contactNumber = contactInfo;
            return contactInfo;
        } else {
            return null;
        }

    }

    public Social addTwitter(String twitterId) {
        //Implement this method
        if (this.socialMediaPointer < 5) {
            Social social = new Social("Twitter", twitterId);
            this.socialMediaAccounts[this.socialMediaPointer++] = social;
            return social;
        } else {
            return null;
        }

    }

    public Social addInstagram(String instagramId) {
        //Implement this method
        if (this.socialMediaPointer < 5) {
            Social social = new Social("Instagram", instagramId);
            this.socialMediaAccounts[this.socialMediaPointer++] = social;
            return social;
        } else {
            return null;
        }

    }

    public Social addSocialMedia(String title, String id) {
        //Implement this method
        if (this.socialMediaPointer < 5) {
            Social social = new Social(title, id);
            this.socialMediaAccounts[this.socialMediaPointer++] = social;
            return social;
        } else {
            return null;
        }

    }

    public ContactInfo[] getInfo() {
        //Implement this method
        int infoPresent = 0;
        if (this.personName != null) {
            infoPresent++;
        }
        if (this.contactNumber != null) {
            infoPresent++;
        }
        infoPresent += (this.socialMediaPointer) + (this.emailAddressPointer);
        ContactInfo[] contactInfos = new ContactInfo[infoPresent];
        int start = 0;
        if (this.personName != null) {
            contactInfos[start++] = personName;
        }
        if (this.contactNumber != null) {
            contactInfos[start++] = this.contactNumber;
        }
        for (int i = 0; i < this.emailAddressPointer; i++) {
            contactInfos[start++] = this.emailAddresses[i];
        }
        for (int i = 0; i < this.socialMediaPointer; i++) {
            contactInfos[start++] = this.socialMediaAccounts[i];
        }
        return contactInfos;
    }

}


