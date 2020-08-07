package com.yuanqi.hc.wsdl.iface;

import com.yuanqi.hc.info.virtualcard.SignVirtualCardInInfo;
import com.yuanqi.hc.info.virtualcard.SignVirtualCardOutInfo;

/**
 * @author wy
 * @create 2020-06-15 15:17
 */
public interface HealthCardService {

    public abstract SignVirtualCardOutInfo SignVirtualCard(SignVirtualCardInInfo paramSignVirtualCardInInfo);
}
