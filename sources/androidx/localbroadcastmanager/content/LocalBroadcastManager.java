package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<LocalBroadcastManager$ReceiverRecord>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<LocalBroadcastManager$ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<LocalBroadcastManager$BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new LocalBroadcastManager$1(this, context.getMainLooper());
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public void executePendingBroadcasts() {
        int size;
        LocalBroadcastManager$BroadcastRecord[] localBroadcastManager$BroadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                localBroadcastManager$BroadcastRecordArr = new LocalBroadcastManager$BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(localBroadcastManager$BroadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                LocalBroadcastManager$BroadcastRecord localBroadcastManager$BroadcastRecord = localBroadcastManager$BroadcastRecordArr[i];
                int size2 = localBroadcastManager$BroadcastRecord.receivers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = localBroadcastManager$BroadcastRecord.receivers.get(i2);
                    if (!localBroadcastManager$ReceiverRecord.dead) {
                        localBroadcastManager$ReceiverRecord.receiver.onReceive(this.mAppContext, localBroadcastManager$BroadcastRecord.intent);
                    }
                }
            }
        }
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = new LocalBroadcastManager$ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(localBroadcastManager$ReceiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(localBroadcastManager$ReceiverRecord);
            }
        }
    }

    public boolean sendBroadcast(@NonNull Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList2;
        String str2;
        String str3;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = (intent.getFlags() & 8) != 0;
            if (z2) {
                Log.v(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z2) {
                    Log.v(TAG, "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = arrayList3.get(i2);
                    if (z2) {
                        Log.v(TAG, "Matching against filter " + localBroadcastManager$ReceiverRecord.filter);
                    }
                    if (localBroadcastManager$ReceiverRecord.broadcasting) {
                        if (z2) {
                            Log.v(TAG, "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = localBroadcastManager$ReceiverRecord.filter.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z2) {
                                Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(localBroadcastManager$ReceiverRecord);
                            localBroadcastManager$ReceiverRecord.broadcasting = true;
                        } else if (z2) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = "action";
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = "data";
                            }
                            Log.v(TAG, "  Filter did not match: " + str3);
                        }
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((LocalBroadcastManager$ReceiverRecord) arrayList5.get(i3)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new LocalBroadcastManager$BroadcastRecord(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<LocalBroadcastManager$ReceiverRecord> arrayListRemove = this.mReceivers.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = arrayListRemove.get(size);
                localBroadcastManager$ReceiverRecord.dead = true;
                for (int i = 0; i < localBroadcastManager$ReceiverRecord.filter.countActions(); i++) {
                    String action = localBroadcastManager$ReceiverRecord.filter.getAction(i);
                    ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord2 = arrayList.get(size2);
                            if (localBroadcastManager$ReceiverRecord2.receiver == broadcastReceiver) {
                                localBroadcastManager$ReceiverRecord2.dead = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
