package edu.neu.cs5200.api.dao;
import java.io.*;
import java.util.*;

import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.persistence.*;


import edu.neu.cs5200.api.model.*;

public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("XSLT_JPA");
	EntityManager em = null;
	
	public Site findSite( int siteId) {
		Site site = null;
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		site = em.find(Site.class, siteId);
		
		em.getTransaction().commit();
		em.close();
		
		return site;
	}
	public List<Site> findAllSites() {
		List<Site> sites = new ArrayList<Site>();
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("findAllSites");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();

		return sites;
	}
	public void exportSitesToXmlFile(Sites sites, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Sites.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sites, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(
			String sitesXmlFileName,
			String outputFileName,
			String xsltFileName)
	{
		File inputXmlFile = new File(sitesXmlFileName);
		File outputXmlFile = new File(outputFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SiteDao dao = new SiteDao();
		
		
		List<Site> sites = dao.findAllSites();
		Sites theSites = new Sites();
		theSites.setSites(sites);
		
		dao.exportSitesToXmlFile(theSites, "xml/sites.xml");
		
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");
	}
	
	
	
	
	
}
