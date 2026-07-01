package com.discord.models.hubs;

import android.content.Context;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DirectoryEntryCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public enum DirectoryEntryCategory {
    Home(-1, 2131888444, 70),
    Uncategorized(0, 2131896571, 0, 4, null),
    SchoolClub(1, 2131888452, 100),
    Class(2, 2131888445, 0, 4, null),
    StudySocial(3, 2131888453, 50),
    SubjectMajor(4, 2131888454, 0, 4, null),
    Misc(5, 2131888450, 0, 4, null),
    HQSocial(1, 2131888446, 0, 4, null),
    HQErgs(2, 2131888447, 0, 4, null),
    HQMisc(3, 2131888448, 0, 4, null),
    HQArchives(5, 2131888449, 0, 4, null);

    public static final DirectoryEntryCategory$Companion Companion = new DirectoryEntryCategory$Companion(null);
    private final int idealSize;
    private final int key;
    private final int titleRes;

    DirectoryEntryCategory(int i, int i2, int i3) {
        this.key = i;
        this.titleRes = i2;
        this.idealSize = i3;
    }

    public final int getIdealSize() {
        return this.idealSize;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getTitle(Context context) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(this.titleRes);
        m.checkNotNullExpressionValue(string, "context.getString(titleRes)");
        return string;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    /* synthetic */ DirectoryEntryCategory(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? Integer.MAX_VALUE : i3);
    }
}
