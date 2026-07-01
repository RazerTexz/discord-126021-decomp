package com.franmontiel.persistentcookiejar.persistence;

import f0.Cookie;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface CookiePersistor {
    void a(Collection<Cookie> collection);

    void removeAll(Collection<Cookie> collection);
}
