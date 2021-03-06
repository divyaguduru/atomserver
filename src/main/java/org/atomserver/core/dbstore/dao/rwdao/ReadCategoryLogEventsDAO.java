/* Copyright Homeaway, Inc 2005-2007. All Rights Reserved.
 * No unauthorized use of this software.
 */
package org.atomserver.core.dbstore.dao.rwdao;

import org.atomserver.core.EntryCategory;
import org.atomserver.core.EntryCategoryLogEvent;
import org.atomserver.core.dbstore.dao.AtomServerDAO;

import java.util.List;

/**
 * The Read-only DAO for accessing an Entry's Category Log Events
 *
 * @author Chris Berry  (chriswberry at gmail.com)
 * @author Bryon Jacob (bryon at jacob.net)
 */
public interface ReadCategoryLogEventsDAO
        extends AtomServerDAO {

    List<EntryCategoryLogEvent> selectEntryCategoryLogEvent(EntryCategory entryQuery);

    List<EntryCategoryLogEvent> selectEntryCategoryLogEventByScheme(EntryCategory entryQuery);

    List<EntryCategoryLogEvent> selectEntryCategoryLogEventBySchemeAndTerm(EntryCategory entryQuery);

    public int getTotalCount(String workspace);

    public int getTotalCount(String workspace, String collection);
}
