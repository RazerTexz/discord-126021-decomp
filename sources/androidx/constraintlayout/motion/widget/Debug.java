package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b.d.b.a.outline;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(") ");
        sbU.append(str);
        sbU.append("  ");
        String string = sbU.toString();
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            PrintStream printStream = System.out;
            StringBuilder sbX = outline.X(string, "     ");
            sbX.append(getName(childAt));
            printStream.println(sbX.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(string + "       " + field.getName() + " " + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(")");
        String string = sbU.toString();
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder sbX = outline.X(string, "------------- ");
        sbX.append(cls.getName());
        sbX.append(" --------------------");
        printStream.println(sbX.toString());
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(string + "    " + field.getName() + " " + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder sbX2 = outline.X(string, "------------- ");
        sbX2.append(cls.getSimpleName());
        sbX2.append(" --------------------");
        printStream2.println(sbX2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(")");
        return sbU.toString();
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(") ");
        sbU.append(stackTraceElement.getMethodName());
        sbU.append("()");
        return sbU.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(")");
        return sbU.toString();
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(")");
        return sbU.toString();
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i) {
        return i == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static void logStack(String str, String str2, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i, stackTrace.length - 1);
        String strW = " ";
        for (int i2 = 1; i2 <= iMin; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder sbU = outline.U(".(");
            sbU.append(stackTrace[i2].getFileName());
            sbU.append(":");
            sbU.append(stackTrace[i2].getLineNumber());
            sbU.append(") ");
            sbU.append(stackTrace[i2].getMethodName());
            String string = sbU.toString();
            strW = outline.w(strW, " ");
            Log.v(str, str2 + strW + string + strW);
        }
    }

    public static void printStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i, stackTrace.length - 1);
        String strW = " ";
        for (int i2 = 1; i2 <= iMin; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder sbU = outline.U(".(");
            sbU.append(stackTrace[i2].getFileName());
            sbU.append(":");
            sbU.append(stackTrace[i2].getLineNumber());
            sbU.append(") ");
            String string = sbU.toString();
            strW = outline.w(strW, " ");
            System.out.println(str + strW + string + strW);
        }
    }

    public static String getName(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return outline.q("?", i);
        }
    }

    public static String getName(Context context, int[] iArr) {
        String resourceEntryName;
        try {
            String str = iArr.length + "[";
            int i = 0;
            while (i < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i == 0 ? "" : " ");
                String string = sb.toString();
                try {
                    resourceEntryName = context.getResources().getResourceEntryName(iArr[i]);
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = "? " + iArr[i] + " ";
                }
                str = string + resourceEntryName;
                i++;
            }
            return str + "]";
        } catch (Exception e) {
            Log.v("DEBUG", e.toString());
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbU = outline.U(".(");
        sbU.append(stackTraceElement.getFileName());
        sbU.append(":");
        sbU.append(stackTraceElement.getLineNumber());
        sbU.append(") ");
        sbU.append(str);
        sbU.append("  ");
        String string = sbU.toString();
        PrintStream printStream = System.out;
        StringBuilder sbY = outline.Y(" >>>>>>>>>>>>>>>>>>. dump ", string, "  ");
        sbY.append(layoutParams.getClass().getName());
        printStream.println(sbY.toString());
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(string + "       " + name + " " + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + string);
    }
}
