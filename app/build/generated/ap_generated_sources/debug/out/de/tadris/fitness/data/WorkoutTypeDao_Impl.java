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
public final class WorkoutTypeDao_Impl implements WorkoutTypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkoutType> __insertionAdapterOfWorkoutType;

  private final EntityDeletionOrUpdateAdapter<WorkoutType> __deletionAdapterOfWorkoutType;

  private final EntityDeletionOrUpdateAdapter<WorkoutType> __updateAdapterOfWorkoutType;

  public WorkoutTypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkoutType = new EntityInsertionAdapter<WorkoutType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workout_type` (`id`,`title`,`min_distance`,`color`,`icon`,`met`,`type`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkoutType value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.id);
        }
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        stmt.bindLong(3, value.minDistance);
        stmt.bindLong(4, value.color);
        if (value.icon == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.icon);
        }
        stmt.bindLong(6, value.MET);
        if (value.recordingType == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.recordingType);
        }
      }
    };
    this.__deletionAdapterOfWorkoutType = new EntityDeletionOrUpdateAdapter<WorkoutType>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `workout_type` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkoutType value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.id);
        }
      }
    };
    this.__updateAdapterOfWorkoutType = new EntityDeletionOrUpdateAdapter<WorkoutType>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workout_type` SET `id` = ?,`title` = ?,`min_distance` = ?,`color` = ?,`icon` = ?,`met` = ?,`type` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkoutType value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.id);
        }
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        stmt.bindLong(3, value.minDistance);
        stmt.bindLong(4, value.color);
        if (value.icon == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.icon);
        }
        stmt.bindLong(6, value.MET);
        if (value.recordingType == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.recordingType);
        }
        if (value.id == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.id);
        }
      }
    };
  }

  @Override
  public void insert(final WorkoutType type) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkoutType.insert(type);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final WorkoutType type) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWorkoutType.handle(type);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final WorkoutType type) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkoutType.handle(type);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public WorkoutType findById(final String id) {
    final String _sql = "SELECT * FROM workout_type WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfMinDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "min_distance");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfMET = CursorUtil.getColumnIndexOrThrow(_cursor, "met");
      final int _cursorIndexOfRecordingType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final WorkoutType _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkoutType();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _result.id = null;
        } else {
          _result.id = _cursor.getString(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _result.title = null;
        } else {
          _result.title = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.minDistance = _cursor.getInt(_cursorIndexOfMinDistance);
        _result.color = _cursor.getInt(_cursorIndexOfColor);
        if (_cursor.isNull(_cursorIndexOfIcon)) {
          _result.icon = null;
        } else {
          _result.icon = _cursor.getString(_cursorIndexOfIcon);
        }
        _result.MET = _cursor.getInt(_cursorIndexOfMET);
        if (_cursor.isNull(_cursorIndexOfRecordingType)) {
          _result.recordingType = null;
        } else {
          _result.recordingType = _cursor.getString(_cursorIndexOfRecordingType);
        }
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
  public WorkoutType[] findAll() {
    final String _sql = "SELECT * FROM workout_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfMinDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "min_distance");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfMET = CursorUtil.getColumnIndexOrThrow(_cursor, "met");
      final int _cursorIndexOfRecordingType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final WorkoutType[] _result = new WorkoutType[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final WorkoutType _item;
        _item = new WorkoutType();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getString(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _item.title = null;
        } else {
          _item.title = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.minDistance = _cursor.getInt(_cursorIndexOfMinDistance);
        _item.color = _cursor.getInt(_cursorIndexOfColor);
        if (_cursor.isNull(_cursorIndexOfIcon)) {
          _item.icon = null;
        } else {
          _item.icon = _cursor.getString(_cursorIndexOfIcon);
        }
        _item.MET = _cursor.getInt(_cursorIndexOfMET);
        if (_cursor.isNull(_cursorIndexOfRecordingType)) {
          _item.recordingType = null;
        } else {
          _item.recordingType = _cursor.getString(_cursorIndexOfRecordingType);
        }
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
