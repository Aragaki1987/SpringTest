package com.san.spring.aspects;

import com.san.spring.bean.DefaultEncoreable;
import com.san.spring.bean.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by AnNN1 on 12/27/2016.
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.san.spring.bean.CompactDisc+",
                defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
