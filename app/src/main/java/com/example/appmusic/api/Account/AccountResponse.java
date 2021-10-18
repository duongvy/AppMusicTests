package com.example.appmusic.api.Account;

public class AccountResponse {
    public class Data
    {
        private CurrentUser currentUser;

        public CurrentUser getCurrentUser ()
        {
            return currentUser;
        }

        public void setCurrentUser (CurrentUser currentUser)
        {
            this.currentUser = currentUser;
        }
    }



    public class CurrentUser
    {
        private String profilePictureUrl;

        private String createdAt;

        private String _id;

        private String fullname;

        private String id;

        private String email;

        private String username;

        private String updatedAt;

        public String getProfilePictureUrl ()
        {
            return profilePictureUrl;
        }

        public void setProfilePictureUrl (String profilePictureUrl)
        {
            this.profilePictureUrl = profilePictureUrl;
        }

        public String getCreatedAt ()
        {
            return createdAt;
        }

        public void setCreatedAt (String createdAt)
        {
            this.createdAt = createdAt;
        }

        public String get_id ()
        {
            return _id;
        }

        public void set_id (String _id)
        {
            this._id = _id;
        }

        public String getFullname ()
        {
            return fullname;
        }

        public void setFullname (String fullname)
        {
            this.fullname = fullname;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getEmail ()
        {
            return email;
        }

        public void setEmail (String email)
        {
            this.email = email;
        }

        public String getUsername ()
        {
            return username;
        }

        public void setUsername (String username)
        {
            this.username = username;
        }

        public String getUpdatedAt ()
        {
            return updatedAt;
        }

        public void setUpdatedAt (String updatedAt)
        {
            this.updatedAt = updatedAt;
        }
    }

    private Data data;

    private String status;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }


}
