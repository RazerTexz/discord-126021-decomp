package com.discord.utilities.embed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FileType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileType$threadLocalMatcher$1 extends ThreadLocal<Matcher> {
    public final /* synthetic */ Pattern $pattern;

    public FileType$threadLocalMatcher$1(Pattern pattern) {
        this.$pattern = pattern;
    }

    @Override // java.lang.ThreadLocal
    public /* bridge */ /* synthetic */ Matcher initialValue() {
        return initialValue2();
    }

    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: initialValue, reason: avoid collision after fix types in other method */
    public Matcher initialValue2() {
        return this.$pattern.matcher("");
    }
}
