//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.19 at 04:19:32 PM ICT 
//


package org.ganglia.client4j.internal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "extradata"
})
@XmlRootElement(name = "METRICS")
public class METRICS {

    @XmlAttribute(name = "NAME", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "SUM", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sum;
    @XmlAttribute(name = "NUM", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String num;
    @XmlAttribute(name = "TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "UNITS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String units;
    @XmlAttribute(name = "SLOPE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String slope;
    @XmlAttribute(name = "SOURCE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String source;
    @XmlElement(name = "EXTRA_DATA")
    protected List<EXTRADATA> extradata;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUM() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUM(String value) {
        this.sum = value;
    }

    /**
     * Gets the value of the num property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUM() {
        return num;
    }

    /**
     * Sets the value of the num property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUM(String value) {
        this.num = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITS() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITS(String value) {
        this.units = value;
    }

    /**
     * Gets the value of the slope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLOPE() {
        return slope;
    }

    /**
     * Sets the value of the slope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLOPE(String value) {
        this.slope = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCE() {
        if (source == null) {
            return "gmond";
        } else {
            return source;
        }
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCE(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the extradata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extradata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEXTRADATA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EXTRADATA }
     * 
     * 
     */
    public List<EXTRADATA> getEXTRADATA() {
        if (extradata == null) {
            extradata = new ArrayList<EXTRADATA>();
        }
        return this.extradata;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("<METRICS ");
        buf.append("NAME=\"" + getNAME() + "\" ");
        buf.append("SUM=\"" + getSUM() + "\" ");
        buf.append("NUM=\"" + getNUM() + "\" ");
        buf.append("TYPE=\"" + getTYPE() + "\" ");
        buf.append("UNITS=\"" + getUNITS() + "\" ");
        buf.append("SLOPE=\"" + getSLOPE() + "\" ");
        buf.append("SOURCE=\"" + getSOURCE() + "\">\n");
        List<EXTRADATA> extras = getEXTRADATA();
        if (extras != null) {
           for (EXTRADATA extra : extras) {
              buf.append(extra.toString());
           }
        }
        buf.append("</METRICS>\n");
        return buf.toString();
    }

}
