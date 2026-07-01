package com.discord.utilities.embed;

import androidx.annotation.DrawableRes;
import com.discord.R;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'VIDEO' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: FileType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileType {
    private static final /* synthetic */ FileType[] $VALUES;
    public static final FileType ACROBAT;
    public static final FileType AE;
    public static final FileType AI;
    public static final FileType ARCHIVE;
    public static final FileType CODE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final FileType DOCUMENT;
    public static final FileType SKETCH;
    public static final FileType SPREADSHEET;
    public static final FileType VIDEO;
    public static final FileType WEBCODE;
    private final ThreadLocal<Matcher> threadLocalMatcher;

    /* JADX INFO: compiled from: FileType.kt */
    public static final class Companion {
        private Companion() {
        }

        public final FileType getFromExtension(String extension) {
            Intrinsics3.checkNotNullParameter(extension, "extension");
            FileType[] fileTypeArrValues = FileType.values();
            for (int i = 0; i < 10; i++) {
                FileType fileType = fileTypeArrValues[i];
                if (fileType.matches(extension)) {
                    return fileType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FileType.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[FileType.VIDEO.ordinal()] = 1;
            iArr[FileType.ACROBAT.ordinal()] = 2;
            iArr[FileType.AE.ordinal()] = 3;
            iArr[FileType.SKETCH.ordinal()] = 4;
            iArr[FileType.AI.ordinal()] = 5;
            iArr[FileType.ARCHIVE.ordinal()] = 6;
            iArr[FileType.CODE.ordinal()] = 7;
            iArr[FileType.DOCUMENT.ordinal()] = 8;
            iArr[FileType.SPREADSHEET.ordinal()] = 9;
            iArr[FileType.WEBCODE.ordinal()] = 10;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("(?:avi|flv|wmv|mov|mp4)$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType = new FileType("VIDEO", 0, patternCompile);
        VIDEO = fileType;
        Pattern patternCompile2 = Pattern.compile("pdf$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType2 = new FileType("ACROBAT", 1, patternCompile2);
        ACROBAT = fileType2;
        Pattern patternCompile3 = Pattern.compile("ae$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType3 = new FileType("AE", 2, patternCompile3);
        AE = fileType3;
        Pattern patternCompile4 = Pattern.compile("sketch$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile4, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType4 = new FileType("SKETCH", 3, patternCompile4);
        SKETCH = fileType4;
        Pattern patternCompile5 = Pattern.compile("ai$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile5, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType5 = new FileType("AI", 4, patternCompile5);
        AI = fileType5;
        Pattern patternCompile6 = Pattern.compile("(?:rar|zip|7z|tar|tar\\.gz)$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile6, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType6 = new FileType("ARCHIVE", 5, patternCompile6);
        ARCHIVE = fileType6;
        String str = "(?:c\\+\\+|cpp|cc|c|h|hpp|mm|m|json|js|rb|rake|py|asm|fs|pyc|dtd|cgi|bat|rss|java|graphml|idb|lua|o|gml|prl|sls|conf|cmake|make|sln|vbe|cxx|wbf|vbs|r|wml|php|bash|applescript|fcgi|yaml|ex|exs|sh|ml|actionscript)$";
        Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder()\n      .a…(\")\\$\")\n      .toString()");
        Pattern patternCompile7 = Pattern.compile(str, 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile7, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType7 = new FileType("CODE", 6, patternCompile7);
        CODE = fileType7;
        Pattern patternCompile8 = Pattern.compile("(?:txt|rtf|doc|docx|md|pages|ppt|pptx|pptm|key|log)$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType8 = new FileType("DOCUMENT", 7, patternCompile8);
        DOCUMENT = fileType8;
        Pattern patternCompile9 = Pattern.compile("(?:xls|xlsx|numbers|csv|xliff)$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType9 = new FileType("SPREADSHEET", 8, patternCompile9);
        SPREADSHEET = fileType9;
        Pattern patternCompile10 = Pattern.compile("(?:html|xhtml|htm|js|xml|xls|xsd|css|styl)$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile10, "java.util.regex.Pattern.compile(this, flags)");
        FileType fileType10 = new FileType("WEBCODE", 9, patternCompile10);
        WEBCODE = fileType10;
        $VALUES = new FileType[]{fileType, fileType2, fileType3, fileType4, fileType5, fileType6, fileType7, fileType8, fileType9, fileType10};
        INSTANCE = new Companion(null);
    }

    private FileType(String str, int i, final Pattern pattern) {
        super(str, i);
        this.threadLocalMatcher = new ThreadLocal<Matcher>() { // from class: com.discord.utilities.embed.FileType$threadLocalMatcher$1
            @Override // java.lang.ThreadLocal
            public Matcher initialValue() {
                return pattern.matcher("");
            }
        };
    }

    private final boolean matches(String extension) {
        Matcher matcher = this.threadLocalMatcher.get();
        Intrinsics3.checkNotNull(matcher);
        return matcher.reset(extension).find();
    }

    public static FileType valueOf(String str) {
        return (FileType) Enum.valueOf(FileType.class, str);
    }

    public static FileType[] values() {
        return (FileType[]) $VALUES.clone();
    }

    @DrawableRes
    public final int getFileDrawable() {
        switch (ordinal()) {
            case 0:
                return R.drawable.ic_file_video;
            case 1:
                return R.drawable.ic_file_acrobat;
            case 2:
                return R.drawable.ic_file_ae;
            case 3:
                return R.drawable.ic_file_sketch;
            case 4:
                return R.drawable.ic_file_ai;
            case 5:
                return R.drawable.ic_file_archive;
            case 6:
                return R.drawable.ic_file_code;
            case 7:
                return R.drawable.ic_file_document;
            case 8:
                return R.drawable.ic_file_spreadsheet;
            case 9:
                return R.drawable.ic_file_webcode;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
