package androidx.core.app;

import android.app.Notification$MessagingStyle$Message;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$MessagingStyle$Message {
    public static final String KEY_DATA_MIME_TYPE = "type";
    public static final String KEY_DATA_URI = "uri";
    public static final String KEY_EXTRAS_BUNDLE = "extras";
    public static final String KEY_NOTIFICATION_PERSON = "sender_person";
    public static final String KEY_PERSON = "person";
    public static final String KEY_SENDER = "sender";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TIMESTAMP = "time";

    @Nullable
    private String mDataMimeType;

    @Nullable
    private Uri mDataUri;
    private Bundle mExtras;

    @Nullable
    private final Person mPerson;
    private final CharSequence mText;
    private final long mTimestamp;

    public NotificationCompat$MessagingStyle$Message(@Nullable CharSequence charSequence, long j, @Nullable Person person) {
        this.mExtras = new Bundle();
        this.mText = charSequence;
        this.mTimestamp = j;
        this.mPerson = person;
    }

    @NonNull
    public static Bundle[] getBundleArrayForMessages(@NonNull List<NotificationCompat$MessagingStyle$Message> list) {
        Bundle[] bundleArr = new Bundle[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bundleArr[i] = list.get(i).toBundle();
        }
        return bundleArr;
    }

    @Nullable
    public static NotificationCompat$MessagingStyle$Message getMessageFromBundle(@NonNull Bundle bundle) {
        Person personBuild;
        try {
            if (bundle.containsKey(KEY_TEXT) && bundle.containsKey("time")) {
                if (bundle.containsKey(KEY_PERSON)) {
                    personBuild = Person.fromBundle(bundle.getBundle(KEY_PERSON));
                } else if (!bundle.containsKey(KEY_NOTIFICATION_PERSON) || Build$VERSION.SDK_INT < 28) {
                    personBuild = bundle.containsKey(KEY_SENDER) ? new Person$Builder().setName(bundle.getCharSequence(KEY_SENDER)).build() : null;
                } else {
                    personBuild = Person.fromAndroidPerson((android.app.Person) bundle.getParcelable(KEY_NOTIFICATION_PERSON));
                }
                NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = new NotificationCompat$MessagingStyle$Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong("time"), personBuild);
                if (bundle.containsKey("type") && bundle.containsKey(KEY_DATA_URI)) {
                    notificationCompat$MessagingStyle$Message.setData(bundle.getString("type"), (Uri) bundle.getParcelable(KEY_DATA_URI));
                }
                if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                    notificationCompat$MessagingStyle$Message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                }
                return notificationCompat$MessagingStyle$Message;
            }
        } catch (ClassCastException unused) {
        }
        return null;
    }

    @NonNull
    public static List<NotificationCompat$MessagingStyle$Message> getMessagesFromBundleArray(@NonNull Parcelable[] parcelableArr) {
        NotificationCompat$MessagingStyle$Message messageFromBundle;
        ArrayList arrayList = new ArrayList(parcelableArr.length);
        for (int i = 0; i < parcelableArr.length; i++) {
            if ((parcelableArr[i] instanceof Bundle) && (messageFromBundle = getMessageFromBundle((Bundle) parcelableArr[i])) != null) {
                arrayList.add(messageFromBundle);
            }
        }
        return arrayList;
    }

    @NonNull
    private Bundle toBundle() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            bundle.putCharSequence(KEY_TEXT, charSequence);
        }
        bundle.putLong("time", this.mTimestamp);
        Person person = this.mPerson;
        if (person != null) {
            bundle.putCharSequence(KEY_SENDER, person.getName());
            if (Build$VERSION.SDK_INT >= 28) {
                bundle.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
            } else {
                bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
            }
        }
        String str = this.mDataMimeType;
        if (str != null) {
            bundle.putString("type", str);
        }
        Uri uri = this.mDataUri;
        if (uri != null) {
            bundle.putParcelable(KEY_DATA_URI, uri);
        }
        Bundle bundle2 = this.mExtras;
        if (bundle2 != null) {
            bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
        }
        return bundle;
    }

    @Nullable
    public String getDataMimeType() {
        return this.mDataMimeType;
    }

    @Nullable
    public Uri getDataUri() {
        return this.mDataUri;
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public Person getPerson() {
        return this.mPerson;
    }

    @Nullable
    @Deprecated
    public CharSequence getSender() {
        Person person = this.mPerson;
        if (person == null) {
            return null;
        }
        return person.getName();
    }

    @Nullable
    public CharSequence getText() {
        return this.mText;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    @NonNull
    public NotificationCompat$MessagingStyle$Message setData(@Nullable String str, @Nullable Uri uri) {
        this.mDataMimeType = str;
        this.mDataUri = uri;
        return this;
    }

    @NonNull
    @RequiresApi(24)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public Notification$MessagingStyle$Message toAndroidMessage() {
        Notification$MessagingStyle$Message notification$MessagingStyle$Message;
        Person person = getPerson();
        if (Build$VERSION.SDK_INT >= 28) {
            notification$MessagingStyle$Message = new Notification$MessagingStyle$Message(getText(), getTimestamp(), person != null ? person.toAndroidPerson() : null);
        } else {
            notification$MessagingStyle$Message = new Notification$MessagingStyle$Message(getText(), getTimestamp(), person != null ? person.getName() : null);
        }
        if (getDataMimeType() != null) {
            notification$MessagingStyle$Message.setData(getDataMimeType(), getDataUri());
        }
        return notification$MessagingStyle$Message;
    }

    @Deprecated
    public NotificationCompat$MessagingStyle$Message(@Nullable CharSequence charSequence, long j, @Nullable CharSequence charSequence2) {
        this(charSequence, j, new Person$Builder().setName(charSequence2).build());
    }
}
