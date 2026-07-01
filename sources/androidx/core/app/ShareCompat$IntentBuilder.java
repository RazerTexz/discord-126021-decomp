package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ShareCompat$IntentBuilder {

    @Nullable
    private ArrayList<String> mBccAddresses;

    @Nullable
    private ArrayList<String> mCcAddresses;

    @Nullable
    private CharSequence mChooserTitle;

    @NonNull
    private final Context mContext;

    @NonNull
    private final Intent mIntent;

    @Nullable
    private ArrayList<Uri> mStreams;

    @Nullable
    private ArrayList<String> mToAddresses;

    public ShareCompat$IntentBuilder(@NonNull Context context) {
        Activity activity;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        Intent action = new Intent().setAction("android.intent.action.SEND");
        this.mIntent = action;
        action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
        action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
        action.addFlags(524288);
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            ComponentName componentName = activity.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
        }
    }

    private void combineArrayExtra(String str, ArrayList<String> arrayList) {
        String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        String[] strArr = new String[arrayList.size() + length];
        arrayList.toArray(strArr);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
        }
        this.mIntent.putExtra(str, strArr);
    }

    @NonNull
    @Deprecated
    public static ShareCompat$IntentBuilder from(@NonNull Activity activity) {
        return new ShareCompat$IntentBuilder(activity);
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailBcc(@NonNull String str) {
        if (this.mBccAddresses == null) {
            this.mBccAddresses = new ArrayList<>();
        }
        this.mBccAddresses.add(str);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailCc(@NonNull String str) {
        if (this.mCcAddresses == null) {
            this.mCcAddresses = new ArrayList<>();
        }
        this.mCcAddresses.add(str);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailTo(@NonNull String str) {
        if (this.mToAddresses == null) {
            this.mToAddresses = new ArrayList<>();
        }
        this.mToAddresses.add(str);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder addStream(@NonNull Uri uri) {
        if (this.mStreams == null) {
            this.mStreams = new ArrayList<>();
        }
        this.mStreams.add(uri);
        return this;
    }

    @NonNull
    public Intent createChooserIntent() {
        return Intent.createChooser(getIntent(), this.mChooserTitle);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public Intent getIntent() {
        ArrayList<String> arrayList = this.mToAddresses;
        if (arrayList != null) {
            combineArrayExtra("android.intent.extra.EMAIL", arrayList);
            this.mToAddresses = null;
        }
        ArrayList<String> arrayList2 = this.mCcAddresses;
        if (arrayList2 != null) {
            combineArrayExtra("android.intent.extra.CC", arrayList2);
            this.mCcAddresses = null;
        }
        ArrayList<String> arrayList3 = this.mBccAddresses;
        if (arrayList3 != null) {
            combineArrayExtra("android.intent.extra.BCC", arrayList3);
            this.mBccAddresses = null;
        }
        ArrayList<Uri> arrayList4 = this.mStreams;
        if (arrayList4 != null && arrayList4.size() > 1) {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            ShareCompat$Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
        } else {
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> arrayList5 = this.mStreams;
            if (arrayList5 == null || arrayList5.isEmpty()) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                ShareCompat$Api16Impl.removeClipData(this.mIntent);
            } else {
                this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
                ShareCompat$Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            }
        }
        return this.mIntent;
    }

    @NonNull
    public ShareCompat$IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
        this.mChooserTitle = charSequence;
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setEmailBcc(@Nullable String[] strArr) {
        this.mIntent.putExtra("android.intent.extra.BCC", strArr);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setEmailCc(@Nullable String[] strArr) {
        this.mIntent.putExtra("android.intent.extra.CC", strArr);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setEmailTo(@Nullable String[] strArr) {
        if (this.mToAddresses != null) {
            this.mToAddresses = null;
        }
        this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setHtmlText(@Nullable String str) {
        this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
        if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
            setText(Html.fromHtml(str));
        }
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setStream(@Nullable Uri uri) {
        this.mStreams = null;
        if (uri != null) {
            addStream(uri);
        }
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setSubject(@Nullable String str) {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setText(@Nullable CharSequence charSequence) {
        this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder setType(@Nullable String str) {
        this.mIntent.setType(str);
        return this;
    }

    public void startChooser() {
        this.mContext.startActivity(createChooserIntent());
    }

    @NonNull
    public ShareCompat$IntentBuilder setChooserTitle(@StringRes int i) {
        return setChooserTitle(this.mContext.getText(i));
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailBcc(@NonNull String[] strArr) {
        combineArrayExtra("android.intent.extra.BCC", strArr);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailCc(@NonNull String[] strArr) {
        combineArrayExtra("android.intent.extra.CC", strArr);
        return this;
    }

    @NonNull
    public ShareCompat$IntentBuilder addEmailTo(@NonNull String[] strArr) {
        combineArrayExtra("android.intent.extra.EMAIL", strArr);
        return this;
    }

    private void combineArrayExtra(@Nullable String str, @NonNull String[] strArr) {
        Intent intent = getIntent();
        String[] stringArrayExtra = intent.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        String[] strArr2 = new String[strArr.length + length];
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
        }
        System.arraycopy(strArr, 0, strArr2, length, strArr.length);
        intent.putExtra(str, strArr2);
    }
}
