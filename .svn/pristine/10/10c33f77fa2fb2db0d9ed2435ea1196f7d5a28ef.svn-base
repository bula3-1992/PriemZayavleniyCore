/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pzfiles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 003-0823
 */
@Entity
@Table(name = "content_file", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentFile.findAll", query = "SELECT c FROM ContentFile c"),
    @NamedQuery(name = "ContentFile.findById", query = "SELECT c FROM ContentFile c WHERE c.id = :id"),
    @NamedQuery(name = "ContentFile.findByBirthDate", query = "SELECT c FROM ContentFile c WHERE c.birthDate = :birthDate"),
    @NamedQuery(name = "ContentFile.findByChkConas", query = "SELECT c FROM ContentFile c WHERE c.chkConas = :chkConas"),
    @NamedQuery(name = "ContentFile.findByChkEp", query = "SELECT c FROM ContentFile c WHERE c.chkEp = :chkEp"),
    @NamedQuery(name = "ContentFile.findByChkException", query = "SELECT c FROM ContentFile c WHERE c.chkException = :chkException"),
    @NamedQuery(name = "ContentFile.findByChkFio", query = "SELECT c FROM ContentFile c WHERE c.chkFio = :chkFio"),
    @NamedQuery(name = "ContentFile.findByChkSkpep", query = "SELECT c FROM ContentFile c WHERE c.chkSkpep = :chkSkpep"),
    @NamedQuery(name = "ContentFile.findByChkXml", query = "SELECT c FROM ContentFile c WHERE c.chkXml = :chkXml"),
    @NamedQuery(name = "ContentFile.findByComplDate", query = "SELECT c FROM ContentFile c WHERE c.complDate = :complDate"),
    @NamedQuery(name = "ContentFile.findByCrDate", query = "SELECT c FROM ContentFile c WHERE c.crDate = :crDate"),
    @NamedQuery(name = "ContentFile.findByCrDepName", query = "SELECT c FROM ContentFile c WHERE c.crDepName = :crDepName"),
    @NamedQuery(name = "ContentFile.findByCrDepNum", query = "SELECT c FROM ContentFile c WHERE c.crDepNum = :crDepNum"),
    @NamedQuery(name = "ContentFile.findByCrPackInn", query = "SELECT c FROM ContentFile c WHERE c.crPackInn = :crPackInn"),
    @NamedQuery(name = "ContentFile.findByCrPackKpp", query = "SELECT c FROM ContentFile c WHERE c.crPackKpp = :crPackKpp"),
    @NamedQuery(name = "ContentFile.findByCrPackName", query = "SELECT c FROM ContentFile c WHERE c.crPackName = :crPackName"),
    @NamedQuery(name = "ContentFile.findByDataSource", query = "SELECT c FROM ContentFile c WHERE c.dataSource = :dataSource"),
    @NamedQuery(name = "ContentFile.findByDocCount", query = "SELECT c FROM ContentFile c WHERE c.docCount = :docCount"),
    @NamedQuery(name = "ContentFile.findByDocType", query = "SELECT c FROM ContentFile c WHERE c.docType = :docType"),
    @NamedQuery(name = "ContentFile.findByExDocCount", query = "SELECT c FROM ContentFile c WHERE c.exDocCount = :exDocCount"),
    @NamedQuery(name = "ContentFile.findByFileName", query = "SELECT c FROM ContentFile c WHERE c.fileName = :fileName"),
    @NamedQuery(name = "ContentFile.findByFileType", query = "SELECT c FROM ContentFile c WHERE c.fileType = :fileType"),
    @NamedQuery(name = "ContentFile.findBySurname", query = "SELECT c FROM ContentFile c WHERE c.surname = :surname"),
    @NamedQuery(name = "ContentFile.findByFirstname", query = "SELECT c FROM ContentFile c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "ContentFile.findBySecondname", query = "SELECT c FROM ContentFile c WHERE c.secondname = :secondname"),
    @NamedQuery(name = "ContentFile.findBySurname", query = "SELECT c FROM ContentFile c WHERE c.surname = :surname"),
    @NamedQuery(name = "ContentFile.findByForm", query = "SELECT c FROM ContentFile c WHERE c.form = :form"),
    @NamedQuery(name = "ContentFile.findByFormat", query = "SELECT c FROM ContentFile c WHERE c.format = :format"),
    @NamedQuery(name = "ContentFile.findByNpfInn", query = "SELECT c FROM ContentFile c WHERE c.npfInn = :npfInn"),
    @NamedQuery(name = "ContentFile.findByNpfKpp", query = "SELECT c FROM ContentFile c WHERE c.npfKpp = :npfKpp"),
    @NamedQuery(name = "ContentFile.findByNpfName", query = "SELECT c FROM ContentFile c WHERE c.npfName = :npfName"),
    @NamedQuery(name = "ContentFile.findByNumByCrDep", query = "SELECT c FROM ContentFile c WHERE c.numByCrDep = :numByCrDep"),
    @NamedQuery(name = "ContentFile.findByNumByJur", query = "SELECT c FROM ContentFile c WHERE c.numByJur = :numByJur"),
    @NamedQuery(name = "ContentFile.findByNumPack", query = "SELECT c FROM ContentFile c WHERE c.numPack = :numPack"),
    @NamedQuery(name = "ContentFile.findByPackNum", query = "SELECT c FROM ContentFile c WHERE c.packNum = :packNum"),
    @NamedQuery(name = "ContentFile.findByPrgName", query = "SELECT c FROM ContentFile c WHERE c.prgName = :prgName"),
    @NamedQuery(name = "ContentFile.findByPrgVrs", query = "SELECT c FROM ContentFile c WHERE c.prgVrs = :prgVrs"),
    @NamedQuery(name = "ContentFile.findByRegDocDate", query = "SELECT c FROM ContentFile c WHERE c.regDocDate = :regDocDate"),
    @NamedQuery(name = "ContentFile.findByRegNum", query = "SELECT c FROM ContentFile c WHERE c.regNum = :regNum"),
    @NamedQuery(name = "ContentFile.findByRegType", query = "SELECT c FROM ContentFile c WHERE c.regType = :regType"),
    @NamedQuery(name = "ContentFile.findBySex", query = "SELECT c FROM ContentFile c WHERE c.sex = :sex"),
    @NamedQuery(name = "ContentFile.findBySnils", query = "SELECT c FROM ContentFile c WHERE c.snils = :snils"),
    @NamedQuery(name = "ContentFile.findByXmlPath", query = "SELECT c FROM ContentFile c WHERE c.xmlPath = :xmlPath"),
    @NamedQuery(name = "ContentFile.findByP7sPath", query = "SELECT c FROM ContentFile c WHERE c.p7sPath = :p7sPath"),
    @NamedQuery(name = "ContentFile.findByCommonChk", query = "SELECT c FROM ContentFile c WHERE c.commonChk = :commonChk")
})
public class ContentFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "chk_conas")
    private String chkConas;
    @Column(name = "chk_ep")
    private String chkEp;
    @Column(name = "chk_exception")
    private String chkException;
    @Column(name = "chk_fio")
    private String chkFio;
    @Column(name = "chk_skpep")
    private String chkSkpep;
    @Column(name = "chk_xml")
    private String chkXml;
    @Column(name = "compl_date")
    @Temporal(TemporalType.DATE)
    private Date complDate;
    @Column(name = "cr_date")
    @Temporal(TemporalType.DATE)
    private Date crDate;
    @Column(name = "cr_dep_name")
    private String crDepName;
    @Column(name = "cr_dep_num")
    private String crDepNum;
    @Column(name = "cr_pack_inn")
    private String crPackInn;
    @Column(name = "cr_pack_kpp")
    private String crPackKpp;
    @Column(name = "cr_pack_name")
    private String crPackName;
    @Column(name = "data_source")
    private String dataSource;
    @Column(name = "doc_count")
    private Integer docCount;
    @Column(name = "doc_type")
    private String docType;
    @Column(name = "ex_doc_count")
    private Integer exDocCount;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "surname")
    private String surname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "secondname")
    private String secondname;
    @Column(name = "form")
    private String form;
    @Column(name = "format")
    private String format;
    @Column(name = "npf_inn")
    private String npfInn;
    @Column(name = "npf_kpp")
    private String npfKpp;
    @Column(name = "npf_name")
    private String npfName;
    @Column(name = "num_by_cr_dep")
    private Integer numByCrDep;
    @Column(name = "num_by_jur")
    private String numByJur;
    @Column(name = "num_pack")
    private Integer numPack;
    @Column(name = "pack_num")
    private Integer packNum;
    @Column(name = "prg_name")
    private String prgName;
    @Column(name = "prg_vrs")
    private String prgVrs;
    @Column(name = "reg_doc_date")
    @Temporal(TemporalType.DATE)
    private Date regDocDate;
    @Column(name = "reg_num")
    private String regNum;
    @Column(name = "reg_type")
    private String regType;
    @Column(name = "sex")
    private String sex;
    @Column(name = "snils")
    private String snils;
    @Column(name = "xml_path")
    private String xmlPath;
    @Column(name = "p7s_path")
    private String p7sPath;
    @Column(name = "common_chk")
    private String commonChk;
    @JoinColumn(name = "id_message", referencedColumnName = "id")
    @ManyToOne
    private Filestore idMessage;

    public ContentFile() {
    }

    public ContentFile(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getChkConas() {
        return chkConas;
    }

    public void setChkConas(String chkConas) {
        this.chkConas = chkConas;
    }

    public String getChkEp() {
        return chkEp;
    }

    public void setChkEp(String chkEp) {
        this.chkEp = chkEp;
    }

    public String getChkException() {
        return chkException;
    }

    public void setChkException(String chkException) {
        this.chkException = chkException;
    }

    public String getChkFio() {
        return chkFio;
    }

    public void setChkFio(String chkFio) {
        this.chkFio = chkFio;
    }

    public String getChkSkpep() {
        return chkSkpep;
    }

    public void setChkSkpep(String chkSkpep) {
        this.chkSkpep = chkSkpep;
    }

    public String getChkXml() {
        return chkXml;
    }

    public void setChkXml(String chkXml) {
        this.chkXml = chkXml;
    }

    public Date getComplDate() {
        return complDate;
    }

    public void setComplDate(Date complDate) {
        this.complDate = complDate;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public String getCrDepName() {
        return crDepName;
    }

    public void setCrDepName(String crDepName) {
        this.crDepName = crDepName;
    }

    public String getCrDepNum() {
        return crDepNum;
    }

    public void setCrDepNum(String crDepNum) {
        this.crDepNum = crDepNum;
    }

    public String getCrPackInn() {
        return crPackInn;
    }

    public void setCrPackInn(String crPackInn) {
        this.crPackInn = crPackInn;
    }

    public String getCrPackKpp() {
        return crPackKpp;
    }

    public void setCrPackKpp(String crPackKpp) {
        this.crPackKpp = crPackKpp;
    }

    public String getCrPackName() {
        return crPackName;
    }

    public void setCrPackName(String crPackName) {
        this.crPackName = crPackName;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getExDocCount() {
        return exDocCount;
    }

    public void setExDocCount(Integer exDocCount) {
        this.exDocCount = exDocCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
    
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNpfInn() {
        return npfInn;
    }

    public void setNpfInn(String npfInn) {
        this.npfInn = npfInn;
    }

    public String getNpfKpp() {
        return npfKpp;
    }

    public void setNpfKpp(String npfKpp) {
        this.npfKpp = npfKpp;
    }

    public String getNpfName() {
        return npfName;
    }

    public void setNpfName(String npfName) {
        this.npfName = npfName;
    }

    public Integer getNumByCrDep() {
        return numByCrDep;
    }

    public void setNumByCrDep(Integer numByCrDep) {
        this.numByCrDep = numByCrDep;
    }

    public String getNumByJur() {
        return numByJur;
    }

    public void setNumByJur(String numByJur) {
        this.numByJur = numByJur;
    }

    public Integer getNumPack() {
        return numPack;
    }

    public void setNumPack(Integer numPack) {
        this.numPack = numPack;
    }

    public Integer getPackNum() {
        return packNum;
    }

    public void setPackNum(Integer packNum) {
        this.packNum = packNum;
    }

    public String getPrgName() {
        return prgName;
    }

    public void setPrgName(String prgName) {
        this.prgName = prgName;
    }

    public String getPrgVrs() {
        return prgVrs;
    }

    public void setPrgVrs(String prgVrs) {
        this.prgVrs = prgVrs;
    }

    public Date getRegDocDate() {
        return regDocDate;
    }

    public void setRegDocDate(Date regDocDate) {
        this.regDocDate = regDocDate;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getP7sPath() {
        return p7sPath;
    }

    public void setP7sPath(String p7sPath) {
        this.p7sPath = p7sPath;
    }

    public String getCommonChk() {
        return commonChk;
    }

    public void setCommonChk(String commonChk) {
        this.commonChk = commonChk;
    }

    public Filestore getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Filestore idMessage) {
        this.idMessage = idMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentFile)) {
            return false;
        }
        ContentFile other = (ContentFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.ContentFile[ id=" + id + " ]";
    }
    
}
