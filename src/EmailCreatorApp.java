
public class EmailCreatorApp {

	public static void main(String[] args) {
		System.out.println("Email Creator\n");
		System.out.println("=====================================================");
		String[] csv = {"   james   ,butler,jbutler@gmail.com",
                "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
                "ART,VENERE,ART@VENERE.ORG"};

		String template = 
			    "To:      {email}\n" +
			    "From:    noreply@deals.com\n" +
			    "Subject: Deals!\n\n" +
			    "Hi {first_name},\n\n" +
			    "We've got some great deals for you. Check our website!";

		for (int i = 0; i < csv.length; i++) {
			insertInfoIntoTemplate(csv[i], template);
		}
	}
	
	public static void insertInfoIntoTemplate(String contactInfo, String template) {
		String[] formattedInfo = contactInfo.replaceAll("\\s","").toLowerCase().split(",");
		for (int i = 0; i < formattedInfo.length; i++) {
			if (i<2) {
				formattedInfo[i] = formattedInfo[i].substring(0, 1).toUpperCase() + formattedInfo[i].substring(1);
			}
			if (i==0) {
				template = template.replaceFirst("first_name",formattedInfo[i]);
			}
			if (i==2) {
				template = template.replaceFirst("email",formattedInfo[i]);
			}
		}
		template = template.replaceAll("\\}", "");
		System.out.println(template.replaceAll("\\{", ""));
		System.out.println("=====================================================");
		System.out.println();
	}

}
