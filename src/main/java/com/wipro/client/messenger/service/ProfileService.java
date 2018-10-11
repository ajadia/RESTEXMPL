package com.wipro.client.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.client.messenger.database.DatabaseClass;
import com.wipro.client.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
    private String date = new Date().toString();

	public ProfileService() {
		profiles.put("Auther-1", new Profile(1,"Profile-1", "Ankit","jadia", date));
		profiles.put("Auther-2", new Profile(2,"Profile-2", "Soni","Ricky", date));
	}

	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		//message.setId(messages.size()+1);
		if(profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public void removeProfile(String profileName) {
		//message.setId(messages.size()+1);
		 profiles.remove(profileName);
	}
}
