package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @Deprecated
    public Room() {
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NonNull Context context, @NonNull Class<T> cls, @NonNull String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, cls, str);
    }

    @NonNull
    public static <T, C> T getGeneratedImplementation(Class<C> cls, String str) {
        String str2;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + "." + str3;
            }
            return (T) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException unused) {
            StringBuilder sbM833U = C1643a.m833U("cannot find implementation for ");
            sbM833U.append(cls.getCanonicalName());
            sbM833U.append(". ");
            sbM833U.append(str3);
            sbM833U.append(" does not exist");
            throw new RuntimeException(sbM833U.toString());
        } catch (IllegalAccessException unused2) {
            StringBuilder sbM833U2 = C1643a.m833U("Cannot access the constructor");
            sbM833U2.append(cls.getCanonicalName());
            throw new RuntimeException(sbM833U2.toString());
        } catch (InstantiationException unused3) {
            StringBuilder sbM833U3 = C1643a.m833U("Failed to create an instance of ");
            sbM833U3.append(cls.getCanonicalName());
            throw new RuntimeException(sbM833U3.toString());
        }
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NonNull Context context, @NonNull Class<T> cls) {
        return new RoomDatabase.Builder<>(context, cls, null);
    }
}
