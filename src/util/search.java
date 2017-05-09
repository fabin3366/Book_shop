package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import bean.publication;

public class search {

	//String filepath;
	//
	// public search(String filepath) {
	// this.filepath = filepath;
	// }

	private ArrayList<publication> allData;

	public search() {
		allData = getAllDataFromXML();
		//this.filepath = path;
		
	}
	// public static Document getDocument() throws ParserConfigurationException,
	// SAXException, IOException {
	// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// DocumentBuilder builder = factory.newDocumentBuilder();
	// Document document = builder
	// .parse("/Users/Tianyun/Documents/eclipse new
	// workspace/comp9321_assn1/WebContent/WEB-INF/web.xml");
	// return document;
	// }

	public ArrayList<publication> getAllDataFromXML() {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// File fl = new File(filepath);
			Document document = builder
					.parse("D:/java workspace/comp9321_assn1_final/WebContent/dblp.xml");
			// Element document = document.getDocumentElement();
			ArrayList<publication> dataList = new ArrayList<publication>();

			NodeList nl1 = document.getElementsByTagName("article");
			dataList = getFirstLevelTagData(nl1, "1");
			NodeList nl2 = document.getElementsByTagName("inproceedings");
			dataList.addAll(getFirstLevelTagData(nl2, "2"));
			NodeList nl3 = document.getElementsByTagName("proceedings");
			dataList.addAll(getFirstLevelTagData(nl3, "3"));
			NodeList nl4 = document.getElementsByTagName("book");
			dataList.addAll(getFirstLevelTagData(nl4, "4"));
			NodeList nl5 = document.getElementsByTagName("incollection");
			dataList.addAll(getFirstLevelTagData(nl5, "5"));
			NodeList nl6 = document.getElementsByTagName("phdthesis");
			dataList.addAll(getFirstLevelTagData(nl6, "6"));
			NodeList nl7 = document.getElementsByTagName("mastersthesis");
			dataList.addAll(getFirstLevelTagData(nl7, "7"));
			NodeList nl8 = document.getElementsByTagName("www");
			dataList.addAll(getFirstLevelTagData(nl8, "8"));

			return dataList;

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<publication> getFirstLevelTagData(NodeList nl, String typeId) {
		ArrayList<publication> list = new ArrayList<publication>();
		int len = nl.getLength(); 
		for (int i = 0; i < len; ++i) {
			Node nd = nl.item(i);
			NodeList nlChild = nd.getChildNodes();
			publication tag = new publication();
			tag.setItemId(typeId + Integer.toString(i));
			int nlChildLen = nlChild.getLength();
			for (int j = 0; j < nlChildLen; ++j) {
				Node ndChild = nlChild.item(j);
				if (ndChild.getNodeName().equals("author")) {
					if (tag.getAuthor() == null) {
						tag.setAuthor(ndChild.getTextContent());
					} else {
						tag.setAuthor(tag.getAuthor() + " " + ndChild.getTextContent());
					}
				}
				else if (ndChild.getNodeName().equals("editor")) {
					tag.setEditor(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("title")) {
					tag.setTitle(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("booktitle")) {
					tag.setBooktitle(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("pages")) {
					tag.setPages(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("year")) {
					tag.setYear(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("address")) {
					tag.setAddress(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("journal")) {
					tag.setJournal(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("volume")) {
					tag.setVolume(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("number")) {
					tag.setNumber(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("month")) {
					tag.setMonth(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("url")) {
					tag.setUrl(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("ee")) {
					tag.setEe(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("cdrom")) {
					tag.setCdrom(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("cite")) {
					tag.setCite(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("publisher")) {
					tag.setPublisher(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("note")) {
					tag.setNote(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("crossref")) {
					tag.setCrossref(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("isbn")) {
					tag.setIsbn(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("series")) {
					tag.setSeries(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("school")) {
					tag.setSchool(ndChild.getTextContent());
				}
				else if (ndChild.getNodeName().equals("chapter")) {
					tag.setChapter(ndChild.getTextContent());
				}

			}
			list.add(tag);
		}
		return list;

	}

	/**
	 * @return the allData
	 */
	public ArrayList<publication> getAllData() {
		return allData;
	}

	public ArrayList<publication> matchKeyWords(String[] keywords, String searchType) {
		// System.out.println("lllllllllll");
		ArrayList<publication> dataList = allData;
		// System.out.println(dataList.size());
		ArrayList<publication> matchedList = new ArrayList<publication>();
		int dataLen = dataList.size();
		for (int i = 0; i < dataLen; ++i) {
			publication matchedPub = dataList.get(i);
			// System.out.println("abc " + matchedPub.getAuthor());
			if (searchType.equals("all")) {
				int keywordLen = keywords.length;
				for (int j = 0; j < keywordLen; ++j) {
					// System.out.println("the key word is -----" +
					// keywords[j]);
					if (matchedPub.getAuthor() != null
							&& matchedPub.getAuthor().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getEditor() != null
							&& matchedPub.getEditor().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);

					} else if (matchedPub.getTitle() != null
							&& matchedPub.getTitle().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getBooktitle() != null
							&& matchedPub.getBooktitle().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					} else if (matchedPub.getPages() != null
							&& matchedPub.getPages().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					// System.out.println(matchedPub.getYear().toUpperCase());
					else if (matchedPub.getYear() != null
							&& matchedPub.getYear().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getAddress() != null
							&& matchedPub.getAddress().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getJournal() != null
							&& matchedPub.getJournal().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getVolume() != null
							&& matchedPub.getVolume().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getNumber() != null
							&& matchedPub.getNumber().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getMonth() != null
							&& matchedPub.getMonth().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getUrl() != null
							&& matchedPub.getUrl().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getEe() != null
							&& matchedPub.getEe().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getCdrom() != null
							&& matchedPub.getCdrom().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getCite() != null
							&& matchedPub.getCite().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getPublisher() != null
							&& matchedPub.getPublisher().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getNote() != null
							&& matchedPub.getNote().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getCrossref() != null
							&& matchedPub.getCrossref().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getIsbn() != null
							&& matchedPub.getIsbn().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getSeries() != null
							&& matchedPub.getSeries().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getSchool() != null
							&& matchedPub.getSchool().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}

					else if (matchedPub.getChapter() != null
							&& matchedPub.getChapter().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);

					}
				} // end for loop in "all"
			} // end if in "all"
			else if (searchType.equals("author")) {
				for (int j = 0; j < keywords.length; ++j) {
					if (matchedPub.getAuthor() != null
							&& matchedPub.getAuthor().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}
				}
			} else if (searchType.equals("title")) {
				for (int j = 0; j < keywords.length; ++j) {
					if (matchedPub.getTitle() != null
							&& matchedPub.getTitle().toUpperCase().contains(keywords[j].toUpperCase())) {
						matchedList.add(matchedPub);
					}
				}
			} else if (searchType.equals("year")) {
				for (int j = 0; j < keywords.length; ++j) {
					if (matchedPub.getYear() != null && matchedPub.getYear().contains(keywords[j])) {
						matchedList.add(matchedPub);
					}
				}
			}
		}
		System.out.println(matchedList.size());
		return matchedList;

	}

	public publication findSingleItem(String id) {
		for (int i = 0; i < allData.size(); ++i) {
			publication tmp = allData.get(i);
			if (tmp.getItemId().equals(id)) {
				return tmp;
			}
		}
		return null;
	}
	
	public ArrayList<publication> removeFromCart(ArrayList<publication> list, String[] id) {
		if (id == null) {
			return null;
		} else {
			for (int i = 0; i < list.size(); ++i) {
				if (id == null) {
					System.out.println("idlengthis null");
				}
				for (int j = 0; j < id.length; ++j) {
					if (id[j].equals(list.get(i).getItemId())) {
						list.remove(i);
					}
				}
			}

			return list;
		}
	}

	public ArrayList<publication> advancedSearch(String title, String year, String author, String type, String isbn) {
		ArrayList<publication> result = new ArrayList<publication>();
		
		//System.out.println("the type is ----------" +type);
		String[] titles = title.split(" ");
		String[] years = year.split(" ");
		String[] authors = author.split(" ");
		String[] isbns = isbn.split(" ");
		boolean[] match = new boolean[4];
		for (int i = 0; i < 4; i++)
			match[i] = false;
		if (!(title == null || title == ""))
			match[0] = true;
		if (!(year == null || year == ""))
			match[1] = true;
		if (!(author == null || author == ""))
			match[2] = true;
		if (!(isbn == null || isbn == ""))
			match[3] = true;
		
		int dataLen = allData.size();
		for (int i = 0; i < dataLen; i++) {
			publication d = allData.get(i);
			boolean[] count = new boolean[5];
			for (int k = 0; k < 4; k++)
				count[k] = false;
			//System.out.println("---"+ type);
			//System.out.println(isbn);
			if (!getPublType(d).equals(type)) {
				continue;
			}
			if (!(title == null || title == "")) {
				for (int j = 0; j < titles.length; j++) {
					if (d.getTitle() != null && d.getTitle().toUpperCase().contains(titles[j].toUpperCase()))
						count[0] = true;
					if (d.getBooktitle() != null && d.getBooktitle().toUpperCase().contains(titles[j].toUpperCase()))
						count[0] = true;
				}
			}
			if (!(year == null || year == "")) {
				for (int j = 0; j < years.length; j++) {
					if (d.getYear() != null && d.getYear().toUpperCase().contains(years[j].toUpperCase()))
						count[1] = true;
				}
			}
			if (!(author == null || author == "")) {
				for (int j = 0; j < authors.length; j++) {
					if (d.getAuthor() != null && d.getAuthor().toUpperCase().contains(authors[j].toUpperCase()))
						count[2] = true;
				}
			}
			if (!(isbn == null || isbn == "")) {
				//System.out.println("mark------");
				for (int j = 0; j < isbns.length; j++) {
					if (d.getIsbn() != null && d.getIsbn().toUpperCase().contains(isbns[j].toUpperCase()))
						count[3] = true;
				}
			}
//			if (!(venue == null || venue == "")) {
//				if (d.getBooktitle() != null && d.getJournal() != null) {
//					for (int j = 0; j < keywords.length; j++) {
//						if (d.getAuthor() != null && d.getAuthor().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getEditor() != null && d.getEditor().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getTitle() != null && d.getTitle().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getBooktitle() != null
//								&& d.getBooktitle().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getPages() != null && d.getPages().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getYear() != null && d.getYear().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getAddress() != null && d.getAddress().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getJournal() != null && d.getJournal().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getVolume() != null && d.getVolume().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getNumber() != null && d.getNumber().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getMonth() != null && d.getMonth().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getUrl() != null && d.getUrl().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getEe() != null && d.getEe().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getCdrom() != null && d.getCdrom().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getCite() != null && d.getCite().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getPublisher() != null
//								&& d.getPublisher().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getNote() != null && d.getNote().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getCrossref() != null
//								&& d.getCrossref().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getIsbn() != null && d.getIsbn().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getSeries() != null && d.getSeries().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getSchool() != null && d.getSchool().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//						if (d.getChapter() != null && d.getChapter().toUpperCase().contains(keywords[j].toUpperCase()))
//							count[3] = true;
//					}
//
//				}
//			}
			boolean m = true;
			for (int l = 0; l < 4; l++) {
				if (match[l] != count[l]) {
					m = false;
				}
			}
			if (m == true)
				result.add(d);

		}
		
		return result;
	}
	
	public String getPublType(publication item){
		String tmpType = item.getItemId().substring(0,1);

		String publType = "";
		if (tmpType.equals("1")){
			publType = "article";
		}
		else if (tmpType.equals("2")){
			publType = "inproceedings";
		}
		else if (tmpType.equals("3")){
			publType = "proceedings";
		}
		else if (tmpType.equals("4")){
			publType = "book";
		}
		else if (tmpType.equals("5")){
			publType = "incollection";
		}
		else if (tmpType.equals("6")){
			publType = "phdthesis";
		}
		else if (tmpType.equals("7")){
			publType = "mastersthesis";
		}
		else if (tmpType.equals("8")){
			publType = "www";
		}
		
		return publType;
	}
	
	public boolean isDuplicated(ArrayList<publication> list, String id){
		//System.out.println("id");
		int len = list.size();
		for (int i = 0; i < len; ++i){
			if (list.get(i).getItemId().equals(id)){
				return true;
			}
		}
		return false;
		
	}

}
