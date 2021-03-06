/*
 * Copyright 2011-2015 L2EMU UNIQUE
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.l2emuproject.proxy.io.packetlog;

import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

import net.l2emuproject.proxy.network.ServiceType;

/**
 * A class that stores a packet log header.
 * 
 * @author savormix
 */
public class LogFileHeader
{
	private final Path _logFile;
	private final long _logFileSize;
	private final int _version;
	private final int _headerSize;
	private final int _footerSize;
	private final long _footerStart;
	private final long _created;
	private final ServiceType _service;
	private final int _protocol;
	private final Set<String> _altModes;
	private final int _compressionType;
	
	private final int _packets;
	private final Map<Integer, Integer> _cp;
	private final Map<Integer, Integer> _sp;
	private final long _totalPacketBytes;
	
	/**
	 * Constructs this header.
	 * 
	 * @param logFile path to the associated log file
	 * @param logFileSize size of the log file or {@code -1}
	 * @param version log file format version
	 * @param headerSize header size in bytes
	 * @param footerSize footer size in bytes
	 * @param footerStart footer offset
	 * @param created log file creation timestamp
	 * @param service associated service type
	 * @param protocol network protocol version (-1 for legacy format logs)
	 * @param altModes alternative modes
	 * @param compressionType compression type
	 * @param packets amount of packets within the file (-1 for legacy format logs)
	 * @param cp client packet amounts within the file (empty for legacy format logs)
	 * @param sp server packet amounts within the file (empty for legacy format logs)
	 * @param totalPacketBytes total amount of bytes with packet payload data
	 */
	LogFileHeader(Path logFile, long logFileSize, int version, int headerSize, int footerSize, long footerStart, long created, ServiceType service, int protocol, Set<String> altModes,
			int compressionType, int packets, Map<Integer, Integer> cp, Map<Integer, Integer> sp, long totalPacketBytes)
	{
		_logFile = logFile;
		_logFileSize = logFileSize;
		_version = version;
		_headerSize = headerSize;
		_footerSize = footerSize;
		_footerStart = footerStart;
		_created = created;
		_service = service;
		_protocol = protocol;
		_altModes = altModes;
		_compressionType = compressionType;
		
		_packets = packets;
		_cp = cp;
		_sp = sp;
		_totalPacketBytes = totalPacketBytes;
	}
	
	/**
	 * Returns the associated historical packet log file.
	 * 
	 * @return path to the associated log file
	 */
	public Path getLogFile()
	{
		return _logFile;
	}
	
	/**
	 * Returns the associated historical packet log file size.
	 * 
	 * @return size of the associated log file or {@code -1}
	 */
	public long getLogFileSize()
	{
		return _logFileSize;
	}
	
	/**
	 * Returns the packet log file format version.
	 * 
	 * @return log file format version
	 */
	public int getVersion()
	{
		return _version;
	}
	
	/**
	 * Returns the service type of the contained packets.
	 * 
	 * @return service type
	 */
	public ServiceType getService()
	{
		return _service;
	}
	
	/**
	 * Returns the packet log's creation time.
	 * 
	 * @return log file creation timestamp
	 */
	public long getCreated()
	{
		return _created;
	}
	
	/**
	 * Returns the amount of packets contained in the associated log file.
	 * 
	 * @return packet count or -1
	 */
	public int getPackets()
	{
		return _packets;
	}
	
	/**
	 * Returns the header size of the associated log file.
	 * 
	 * @return header size in bytes
	 */
	public int getHeaderSize()
	{
		return _headerSize;
	}
	
	/**
	 * Returns the footer size of the associated log file.
	 * 
	 * @return footer size in bytes
	 */
	public int getFooterSize()
	{
		return _footerSize;
	}
	
	/**
	 * Returns the protocol revision number, as negotiated during the connection.
	 * 
	 * @return network protocol version or -1
	 */
	public int getProtocol()
	{
		return _protocol;
	}
	
	/**
	 * Alternative game modes used by the server.
	 * 
	 * @return alternative modes
	 */
	public Set<String> getAltModes()
	{
		return _altModes;
	}
	
	/**
	 * Type of compression used in this packet log.
	 * 
	 * @return compression type
	 */
	public int getCompressionType()
	{
		return _compressionType;
	}
	
	/**
	 * Returns the client packet amount map for the associated packet log file.
	 * 
	 * @return client packet amounts within the file
	 */
	public Map<Integer, Integer> getCp()
	{
		return _cp;
	}
	
	/**
	 * Returns the server packet amount map for the associated packet log file.
	 * 
	 * @return server packet amounts within the file
	 */
	public Map<Integer, Integer> getSp()
	{
		return _sp;
	}
	
	/**
	 * Returns the total amount of bytes used by packet payload data.
	 * 
	 * @return total bytes of packet content
	 */
	public long getTotalPacketBytes()
	{
		return _totalPacketBytes;
	}
	
	/**
	 * Returns the footer offset in the associated log file.
	 * 
	 * @return footer offset
	 */
	public long getFooterStart()
	{
		return _footerStart;
	}
	
	@Override
	public String toString()
	{
		return _logFile.toString();
	}
}
