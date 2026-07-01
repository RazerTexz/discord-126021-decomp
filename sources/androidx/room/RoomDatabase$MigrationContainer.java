package androidx.room;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class RoomDatabase$MigrationContainer {
    private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();

    private void addMigration(Migration migration) {
        int i = migration.startVersion;
        int i2 = migration.endVersion;
        TreeMap<Integer, Migration> treeMap = this.mMigrations.get(Integer.valueOf(i));
        if (treeMap == null) {
            treeMap = new TreeMap<>();
            this.mMigrations.put(Integer.valueOf(i), treeMap);
        }
        Migration migration2 = treeMap.get(Integer.valueOf(i2));
        if (migration2 != null) {
            Log.w(Room.LOG_TAG, "Overriding migration " + migration2 + " with " + migration);
        }
        treeMap.put(Integer.valueOf(i2), migration);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    /* JADX WARN: Code duplicated, block: B:31:0x0016 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:? A[LOOP:1: B:13:0x0026->B:43:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017 A[DONT_INVERT] */
    private List<Migration> findUpMigrationPath(List<Migration> list, boolean z2, int i, int i2) {
        TreeMap<Integer, Migration> treeMap;
        Set<Integer> setKeySet;
        Iterator<Integer> it;
        boolean z3;
        boolean z4;
        int iIntValue;
        do {
            if (!z2) {
                if (i <= i2) {
                    return list;
                }
                treeMap = this.mMigrations.get(Integer.valueOf(i));
                if (treeMap == null) {
                    if (z2) {
                        setKeySet = treeMap.descendingKeySet();
                    } else {
                        setKeySet = treeMap.keySet();
                    }
                    it = setKeySet.iterator();
                    while (true) {
                        z3 = true;
                        z4 = false;
                        if (it.hasNext()) {
                            z3 = false;
                            break;
                            break;
                        }
                        iIntValue = it.next().intValue();
                        if (z2) {
                            if (iIntValue > i2) {
                            }
                        } else if (iIntValue < i2) {
                        }
                        if (z4) {
                            list.add(treeMap.get(Integer.valueOf(iIntValue)));
                            i = iIntValue;
                            break;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } else {
                if (i >= i2) {
                    return list;
                }
                treeMap = this.mMigrations.get(Integer.valueOf(i));
                if (treeMap == null) {
                    if (z2) {
                        setKeySet = treeMap.descendingKeySet();
                    } else {
                        setKeySet = treeMap.keySet();
                    }
                    it = setKeySet.iterator();
                    while (true) {
                        z3 = true;
                        z4 = false;
                        if (it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        iIntValue = it.next().intValue();
                        if (z2) {
                            if (iIntValue > i2 && iIntValue > i) {
                                z4 = true;
                            }
                        } else if (iIntValue < i2 && iIntValue < i) {
                            z4 = true;
                        }
                        if (z4) {
                            list.add(treeMap.get(Integer.valueOf(iIntValue)));
                            i = iIntValue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            }
        } while (z3);
        return null;
    }

    public void addMigrations(@NonNull Migration... migrationArr) {
        for (Migration migration : migrationArr) {
            addMigration(migration);
        }
    }

    @Nullable
    public List<Migration> findMigrationPath(int i, int i2) {
        if (i == i2) {
            return Collections.emptyList();
        }
        return findUpMigrationPath(new ArrayList(), i2 > i, i, i2);
    }
}
