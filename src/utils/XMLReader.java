/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import models.pzfiles.ContentFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author 003-0823
 */
public class XMLReader {

    public static String getFio(byte[] xml) {
        try {

            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder;
            builder = f.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml));
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Фамилия/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Фамилия/text()");
            String fam = (String) expr.evaluate(doc, XPathConstants.STRING);
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Имя/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Имя/text()");
            String im = (String) expr.evaluate(doc, XPathConstants.STRING);
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Отчество/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Отчество/text()");
            String ot = (String) expr.evaluate(doc, XPathConstants.STRING);
            String fio = fam + " " + im;
            if (!ot.equals("")) {
                fio += " " + ot;
            }
            return fio;
        } catch (IOException | ParserConfigurationException | TransformerException | XPathExpressionException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static String getSnils(byte[] xml) {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder;
            builder = f.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml));
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/СтраховойНомер/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/СтраховойНомер/text()");
            String snils = (String) expr.evaluate(doc, XPathConstants.STRING);
            return snils;
        } catch (IOException | ParserConfigurationException | TransformerException | XPathExpressionException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static String getDate(byte[] xml) {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder;
            builder = f.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml));
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ДатаЗаполнения/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ДатаЗаполнения/text()");
            String date = (String) expr.evaluate(doc, XPathConstants.STRING);
            if (date.contains("/")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse("19/10/73"));
                return sdf2.format(cal.getTime());
            } else if (date.contains(".")) {
                return date;
            }
            return "";

        } catch (IOException | ParserConfigurationException | TransformerException | XPathExpressionException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static String getSender(byte[] xml) {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder;
            builder = f.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml));
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/РегистрационныйНомер/text()");
            String senderregnumber = (String) expr.evaluate(doc, XPathConstants.STRING);
            return senderregnumber;
        } catch (IOException | ParserConfigurationException | TransformerException | XPathExpressionException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static ContentFile getAllAttributes(byte[] xml, ContentFile curcontent) throws ParseException {
        ContentFile content = curcontent;
        Logger.getLogger(XMLReader.class.getName()).log(Level.INFO, "Чтение данных из заявления ");
        DateUtils du = new DateUtils();
        try {
            XPathFactory xPathfactory;
            XPath xpath;
            XPathExpression expr;
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder;
            builder = f.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml));
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            xPathfactory = XPathFactory.newInstance();
            xpath = xPathfactory.newXPath();
            expr = xpath.compile("//ИмяФайла/text()");
            content.setFileName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ЗаголовокФайла/ВерсияФормата/text()");
            content.setFormat((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ЗаголовокФайла/ТипФайла/text()");
            content.setFileType((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ЗаголовокФайла/ПрограммаПодготовкиДанных/НазваниеПрограммы/text()");
            content.setPrgName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ЗаголовокФайла/ПрограммаПодготовкиДанных/Версия/text()");
            content.setPrgVrs((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ЗаголовокФайла/ИсточникДанных/text()");
            content.setDataSource((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/НомерВпачке/text()");
            content.setPackNum(Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/ТипВходящейОписи/text()");
            content.setRegType((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/НалоговыйНомер/ИНН/text()");
            content.setCrPackInn((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/НалоговыйНомер/КПП/text()");
            content.setCrPackKpp((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/Форма/text()");
            content.setForm((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/НаименованиеОрганизации/text()");
            content.setCrPackName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/РегистрационныйНомер/text()");
            content.setRegNum((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/Подразделение/НаименованиеПодразделения/text()");
            content.setCrDepName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставительПачки/Подразделение/НомерПодразделения/text()");
            content.setCrDepName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/НомерПачки/ПоПодразделению/text()");
            content.setNumByCrDep(Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставДокументов/Количество/text()");
            content.setDocCount(Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставДокументов/НаличиеДокументов/ТипДокумента/text()");
            content.setDocType((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/СоставДокументов/НаличиеДокументов/Количество/text()");
            content.setExDocCount(Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ВХОДЯЩАЯ_ОПИСЬ/ДатаСоставления/text()");
            content.setCrDate(du.createDate((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НомерВпачке/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/НомерВпачке/text()");
            content.setNumPack(Integer.parseInt((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/СтраховойНомер/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/СтраховойНомер/text()");
            content.setSnils((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Фамилия/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Фамилия/text()");
            content.setSurname((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Имя/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Имя/text()");
            content.setFirstname((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ФИО/Отчество/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ФИО/Отчество/text()");
            content.setSecondname((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/Пол/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/Пол/text()");
            content.setSex((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ДатаРождения/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ДатаРождения/text()");
            content.setBirthDate(du.createDate((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ДатаЗаполнения/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ДатаЗаполнения/text()");
            content.setComplDate(du.createDate((String) expr.evaluate(doc, XPathConstants.STRING)));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НПФ/НалоговыйНомер/ИНН/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НовыйНПФ/НалоговыйНомер/ИНН/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/НовыйНПФ/НалоговыйНомер/ИНН/text()");
            content.setNpfInn((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НПФ/НалоговыйНомер/КПП/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НовыйНПФ/НалоговыйНомер/КПП/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/НовыйНПФ/НалоговыйНомер/КПП/text()");
            content.setNpfKpp((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НПФ/НаименованиеОрганизации/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НовыйНПФ/НаименованиеОрганизации/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/НовыйНПФ/НаименованиеОрганизации/text()");
            content.setNpfName((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/НомерПоЖурналу/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/НомерПоЖурналу/text()");
            content.setNumByJur((String) expr.evaluate(doc, XPathConstants.STRING));
            expr = xpath.compile("//ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_ВЫБОРЕ_НПФ/ДатаРегистрацииДокумента/text() | //ПачкаВходящихДокументов/ЗАЯВЛЕНИЕ_О_СМЕНЕ_НПФ/ДатаРегистрацииДокумента/text()");
            content.setRegDocDate(du.createDate((String) expr.evaluate(doc, XPathConstants.STRING)));
            Logger.getLogger(XMLReader.class.getName()).log(Level.INFO, "Данные успешно прочитаны из файла" + content.getFileName());

        } catch (IOException | ParserConfigurationException | TransformerException | XPathExpressionException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, "Open file error", ex);
        }
        return content;
    }
}
