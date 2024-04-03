package de.tadris.fitness.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IntervalDao_Impl implements IntervalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IntervalSet> __insertionAdapterOfIntervalSet;

  private final EntityInsertionAdapter<Interval> __insertionAdapterOfInterval;

  private final EntityDeletionOrUpdateAdapter<Interval> __deletionAdapterOfInterval;

  private final EntityDeletionOrUpdateAdapter<Interval> __updateAdapterOfInterval;

  private final EntityDeletionOrUpdateAdapter<IntervalSet> __updateAdapterOfIntervalSet;

  public IntervalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIntervalSet = new EntityInsertionAdapter<IntervalSet>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `interval_set` (`id`,`name`,`state`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IntervalSet value) {
        stmt.bindLong(1, value.id);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.state);
      }
    };
    this.__insertionAdapterOfInterval = new EntityInsertionAdapter<Interval>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `interval` (`id`,`set_id`,`name`,`delay_millis`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Interval value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.setId);
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        stmt.bindLong(4, value.delayMillis);
      }
    };
    this.__deletionAdapterOfInterval = new EntityDeletionOrUpdateAdapter<Interval>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `interval` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Interval value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfInterval = new EntityDeletionOrUpdateAdapter<Interval>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `interval` SET `id` = ?,`set_id` = ?,`name` = ?,`delay_millis` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Interval value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.setId);
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        stmt.bindLong(4, value.delayMillis);
        stmt.bindLong(5, value.id);
      }
    };
    this.__updateAdapterOfIntervalSet = new EntityDeletionOrUpdateAdapter<IntervalSet>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `interval_set` SET `id` = ?,`name` = ?,`state` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IntervalSet value) {
        stmt.bindLong(1, value.id);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.state);
        stmt.bindLong(4, value.id);
      }
    };
  }

  @Override
  public void insertIntervalSet(final IntervalSet set) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIntervalSet.insert(set);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertInterval(final Interval interval) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInterval.insert(interval);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteInterval(final Interval interval) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfInterval.handle(interval);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateInterval(final Interval interval) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfInterval.handle(interval);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateIntervalSet(final IntervalSet set) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIntervalSet.handle(set);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Interval findById(final long id) {
    final String _sql = "SELECT * FROM interval WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSetId = CursorUtil.getColumnIndexOrThrow(_cursor, "set_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDelayMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "delay_millis");
      final Interval _result;
      if(_cursor.moveToFirst()) {
        _result = new Interval();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.setId = _cursor.getLong(_cursorIndexOfSetId);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _result.name = null;
        } else {
          _result.name = _cursor.getString(_cursorIndexOfName);
        }
        _result.delayMillis = _cursor.getLong(_cursorIndexOfDelayMillis);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IntervalSet getSet(final long id) {
    final String _sql = "SELECT * FROM interval_set WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final IntervalSet _result;
      if(_cursor.moveToFirst()) {
        _result = new IntervalSet();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _result.name = null;
        } else {
          _result.name = _cursor.getString(_cursorIndexOfName);
        }
        _result.state = _cursor.getInt(_cursorIndexOfState);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Interval[] getAllIntervalsOfSet(final long setId) {
    final String _sql = "SELECT * FROM interval WHERE set_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, setId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSetId = CursorUtil.getColumnIndexOrThrow(_cursor, "set_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDelayMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "delay_millis");
      final Interval[] _result = new Interval[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Interval _item;
        _item = new Interval();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.setId = _cursor.getLong(_cursorIndexOfSetId);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        _item.delayMillis = _cursor.getLong(_cursorIndexOfDelayMillis);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IntervalSet[] getVisibleSets() {
    final String _sql = "SELECT * FROM interval_set where state = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final IntervalSet[] _result = new IntervalSet[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IntervalSet _item;
        _item = new IntervalSet();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        _item.state = _cursor.getInt(_cursorIndexOfState);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public IntervalSet[] getAllSets() {
    final String _sql = "SELECT * FROM interval_set";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final IntervalSet[] _result = new IntervalSet[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final IntervalSet _item;
        _item = new IntervalSet();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        _item.state = _cursor.getInt(_cursorIndexOfState);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
