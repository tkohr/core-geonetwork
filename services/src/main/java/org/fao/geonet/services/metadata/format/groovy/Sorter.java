package org.fao.geonet.services.metadata.format.groovy;

import groovy.util.slurpersupport.GPathResult;

import java.util.Comparator;

/**
 * A strategy for controlling the order that the transformed data of an element is added to the resulting document.  A Sorter
 * applies to a parent element and sorts all the child (and associated data) elements of that element.
 *
 * @author Jesse on 10/20/2014.
 */
public abstract class Sorter {
    private final Comparator<SortData> comparator;

    protected Sorter(Comparator<SortData> comparator) {
        this.comparator = comparator;
    }

    /**
     * Return true if the sorter should sort the children of the element.
     */
    public abstract boolean matches(TransformationContext context, GPathResult result);

    /**
     * This is essentially the same as a Comparator's compare method.
     */
    public int compare(SortData sd1, SortData sd2) {
        return this.comparator.compare(sd1, sd2);
    }
}
