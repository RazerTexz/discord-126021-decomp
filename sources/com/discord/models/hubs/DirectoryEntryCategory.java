package com.discord.models.hubs;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.R;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Class' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: DirectoryEntryCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryCategory {
    private static final /* synthetic */ DirectoryEntryCategory[] $VALUES;
    public static final DirectoryEntryCategory Class;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final DirectoryEntryCategory HQArchives;
    public static final DirectoryEntryCategory HQErgs;
    public static final DirectoryEntryCategory HQMisc;
    public static final DirectoryEntryCategory HQSocial;
    public static final DirectoryEntryCategory Home;
    public static final DirectoryEntryCategory Misc;
    public static final DirectoryEntryCategory SchoolClub;
    public static final DirectoryEntryCategory StudySocial;
    public static final DirectoryEntryCategory SubjectMajor;
    public static final DirectoryEntryCategory Uncategorized;
    private final int idealSize;
    private final int key;
    private final int titleRes;

    /* JADX INFO: compiled from: DirectoryEntryCategory.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DirectoryEntryCategory findByKey(int key, boolean isHQDirectoryChannel) {
            Object next;
            Iterator<T> it = getCategories(isHQDirectoryChannel).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((DirectoryEntryCategory) next).getKey() == key));
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) next;
            return directoryEntryCategory != null ? directoryEntryCategory : DirectoryEntryCategory.Uncategorized;
        }

        public final List<DirectoryEntryCategory> getCategories(boolean isHQDirectoryChannel) {
            return isHQDirectoryChannel ? DirectoryEntryCategory2.HQ_DIRECTORY_CATEGORIES : DirectoryEntryCategory2.HUB_CATEGORIES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DirectoryEntryCategory directoryEntryCategory = new DirectoryEntryCategory("Home", 0, -1, R.string.directory_category_all, 70);
        Home = directoryEntryCategory;
        DirectoryEntryCategory directoryEntryCategory2 = new DirectoryEntryCategory("Uncategorized", 1, 0, R.string.uncategorized, 0, 4, null);
        Uncategorized = directoryEntryCategory2;
        DirectoryEntryCategory directoryEntryCategory3 = new DirectoryEntryCategory("SchoolClub", 2, 1, R.string.directory_category_school_club, 100);
        SchoolClub = directoryEntryCategory3;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        DirectoryEntryCategory directoryEntryCategory4 = new DirectoryEntryCategory("Class", 3, 2, R.string.directory_category_class, 0, i, defaultConstructorMarker);
        Class = directoryEntryCategory4;
        DirectoryEntryCategory directoryEntryCategory5 = new DirectoryEntryCategory("StudySocial", 4, 3, R.string.directory_category_study_social, 50);
        StudySocial = directoryEntryCategory5;
        int i2 = 0;
        DirectoryEntryCategory directoryEntryCategory6 = new DirectoryEntryCategory("SubjectMajor", 5, 4, R.string.directory_category_subject_major, i2, i, defaultConstructorMarker);
        SubjectMajor = directoryEntryCategory6;
        DirectoryEntryCategory directoryEntryCategory7 = new DirectoryEntryCategory("Misc", 6, 5, R.string.directory_category_miscellaneous, i2, i, defaultConstructorMarker);
        Misc = directoryEntryCategory7;
        DirectoryEntryCategory directoryEntryCategory8 = new DirectoryEntryCategory("HQSocial", 7, 1, R.string.directory_category_internal_1, i2, i, defaultConstructorMarker);
        HQSocial = directoryEntryCategory8;
        DirectoryEntryCategory directoryEntryCategory9 = new DirectoryEntryCategory("HQErgs", 8, 2, R.string.directory_category_internal_2, i2, i, defaultConstructorMarker);
        HQErgs = directoryEntryCategory9;
        DirectoryEntryCategory directoryEntryCategory10 = new DirectoryEntryCategory("HQMisc", 9, 3, R.string.directory_category_internal_3, i2, i, defaultConstructorMarker);
        HQMisc = directoryEntryCategory10;
        DirectoryEntryCategory directoryEntryCategory11 = new DirectoryEntryCategory("HQArchives", 10, 5, R.string.directory_category_internal_5, i2, i, defaultConstructorMarker);
        HQArchives = directoryEntryCategory11;
        $VALUES = new DirectoryEntryCategory[]{directoryEntryCategory, directoryEntryCategory2, directoryEntryCategory3, directoryEntryCategory4, directoryEntryCategory5, directoryEntryCategory6, directoryEntryCategory7, directoryEntryCategory8, directoryEntryCategory9, directoryEntryCategory10, directoryEntryCategory11};
        INSTANCE = new Companion(null);
    }

    private DirectoryEntryCategory(String str, @StringRes int i, int i2, int i3, int i4) {
        super(str, i);
        this.key = i2;
        this.titleRes = i3;
        this.idealSize = i4;
    }

    public static DirectoryEntryCategory valueOf(String str) {
        return (DirectoryEntryCategory) Enum.valueOf(DirectoryEntryCategory.class, str);
    }

    public static DirectoryEntryCategory[] values() {
        return (DirectoryEntryCategory[]) $VALUES.clone();
    }

    public final int getIdealSize() {
        return this.idealSize;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getTitle(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(this.titleRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(titleRes)");
        return string;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public /* synthetic */ DirectoryEntryCategory(String str, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i5 & 4) != 0 ? Integer.MAX_VALUE : i4);
    }
}
