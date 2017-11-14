
public class HTMLConverterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HTML Converter\n");
		System.out.println("Input");
		String html = "<h1>Grocery List</h1>\n<ul>\n    <li>Eggs</li>\n    <li>Milk</li>\n    <li>Butter</li>\n</ul>";
		System.out.println(html);
		System.out.println();
		System.out.println("Output");
		StringBuilder sb = new StringBuilder(html);
		StringBuilder ns = new StringBuilder(html.length());
		boolean isHTML = false;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i)=='<') {
				isHTML = true;
			} else if(sb.charAt(i-1)=='>') {
				isHTML = false;
			}
			if (i>0) {
				if (sb.charAt(i-1)=='<'&&sb.charAt(i)=='l') {
					ns.append('*');
					ns.append(' ');
				}
			}
			if (!isHTML&&sb.charAt(i)!=' ') {
				ns.append(sb.charAt(i));
			}
		}
//		removing extra line break
		ns.delete(11, 12);
		System.out.println(ns);
	}

}
