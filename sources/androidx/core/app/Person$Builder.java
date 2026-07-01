package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class Person$Builder {

    @Nullable
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;

    @Nullable
    public String mKey;

    @Nullable
    public CharSequence mName;

    @Nullable
    public String mUri;

    public Person$Builder() {
    }

    @NonNull
    public Person build() {
        return new Person(this);
    }

    @NonNull
    public Person$Builder setBot(boolean z2) {
        this.mIsBot = z2;
        return this;
    }

    @NonNull
    public Person$Builder setIcon(@Nullable IconCompat iconCompat) {
        this.mIcon = iconCompat;
        return this;
    }

    @NonNull
    public Person$Builder setImportant(boolean z2) {
        this.mIsImportant = z2;
        return this;
    }

    @NonNull
    public Person$Builder setKey(@Nullable String str) {
        this.mKey = str;
        return this;
    }

    @NonNull
    public Person$Builder setName(@Nullable CharSequence charSequence) {
        this.mName = charSequence;
        return this;
    }

    @NonNull
    public Person$Builder setUri(@Nullable String str) {
        this.mUri = str;
        return this;
    }

    public Person$Builder(Person person) {
        this.mName = person.mName;
        this.mIcon = person.mIcon;
        this.mUri = person.mUri;
        this.mKey = person.mKey;
        this.mIsBot = person.mIsBot;
        this.mIsImportant = person.mIsImportant;
    }
}
