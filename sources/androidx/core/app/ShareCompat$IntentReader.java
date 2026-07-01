package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ShareCompat$IntentReader {
    private static final String TAG = "IntentReader";

    @Nullable
    private final ComponentName mCallingActivity;

    @Nullable
    private final String mCallingPackage;

    @NonNull
    private final Context mContext;

    @NonNull
    private final Intent mIntent;

    @Nullable
    private ArrayList<Uri> mStreams;

    public ShareCompat$IntentReader(@NonNull Activity activity) {
        this((Context) Preconditions.checkNotNull(activity), activity.getIntent());
    }

    @NonNull
    @Deprecated
    public static ShareCompat$IntentReader from(@NonNull Activity activity) {
        return new ShareCompat$IntentReader(activity);
    }

    private static void withinStyle(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt == '>') {
                sb.append("&gt;");
            } else if (cCharAt == '&') {
                sb.append("&amp;");
            } else if (cCharAt > '~' || cCharAt < ' ') {
                sb.append("&#");
                sb.append((int) cCharAt);
                sb.append(";");
            } else if (cCharAt == ' ') {
                while (true) {
                    int i3 = i + 1;
                    if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                        break;
                    }
                    sb.append("&nbsp;");
                    i = i3;
                }
                sb.append(' ');
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
    }

    @Nullable
    public ComponentName getCallingActivity() {
        return this.mCallingActivity;
    }

    @Nullable
    public Drawable getCallingActivityIcon() {
        if (this.mCallingActivity == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getActivityIcon(this.mCallingActivity);
        } catch (PackageManager$NameNotFoundException e) {
            Log.e(TAG, "Could not retrieve icon for calling activity", e);
            return null;
        }
    }

    @Nullable
    public Drawable getCallingApplicationIcon() {
        if (this.mCallingPackage == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getApplicationIcon(this.mCallingPackage);
        } catch (PackageManager$NameNotFoundException e) {
            Log.e(TAG, "Could not retrieve icon for calling application", e);
            return null;
        }
    }

    @Nullable
    public CharSequence getCallingApplicationLabel() {
        if (this.mCallingPackage == null) {
            return null;
        }
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
        } catch (PackageManager$NameNotFoundException e) {
            Log.e(TAG, "Could not retrieve label for calling application", e);
            return null;
        }
    }

    @Nullable
    public String getCallingPackage() {
        return this.mCallingPackage;
    }

    @Nullable
    public String[] getEmailBcc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }

    @Nullable
    public String[] getEmailCc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }

    @Nullable
    public String[] getEmailTo() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    @Nullable
    public String getHtmlText() {
        String stringExtra = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
        if (stringExtra != null) {
            return stringExtra;
        }
        CharSequence text = getText();
        if (text instanceof Spanned) {
            return Html.toHtml((Spanned) text);
        }
        return text != null ? Html.escapeHtml(text) : stringExtra;
    }

    @Nullable
    public Uri getStream() {
        return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }

    public int getStreamCount() {
        if (this.mStreams == null && isMultipleShare()) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        ArrayList<Uri> arrayList = this.mStreams;
        return arrayList != null ? arrayList.size() : this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
    }

    @Nullable
    public String getSubject() {
        return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }

    @Nullable
    public CharSequence getText() {
        return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    @Nullable
    public String getType() {
        return this.mIntent.getType();
    }

    public boolean isMultipleShare() {
        return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }

    public boolean isShareIntent() {
        String action = this.mIntent.getAction();
        return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
    }

    public boolean isSingleShare() {
        return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }

    public ShareCompat$IntentReader(@NonNull Context context, @NonNull Intent intent) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mIntent = (Intent) Preconditions.checkNotNull(intent);
        this.mCallingPackage = ShareCompat.getCallingPackage(intent);
        this.mCallingActivity = ShareCompat.getCallingActivity(intent);
    }

    @Nullable
    public Uri getStream(int i) {
        if (this.mStreams == null && isMultipleShare()) {
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        ArrayList<Uri> arrayList = this.mStreams;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        if (i == 0) {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }
        StringBuilder sbU = a.U("Stream items available: ");
        sbU.append(getStreamCount());
        sbU.append(" index requested: ");
        sbU.append(i);
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
