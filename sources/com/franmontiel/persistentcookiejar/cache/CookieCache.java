package com.franmontiel.persistentcookiejar.cache;

import f0.Cookie;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface CookieCache extends Iterable<Cookie> {
    void addAll(Collection<Cookie> collection);
}
