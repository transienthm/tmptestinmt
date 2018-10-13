package org.java.bin.effective;

import java.util.*;

/**
 * 描述:
 *
 * @author Alcalde
 * @create 2018-10-06 下午7:52
 */
public class CloneTest implements Cloneable {

    @Override
    protected synchronized Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}
