/*
 * Copyright (C) 2011. 2012 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cc.spray.can
package config

import akka.util.Duration
import cc.spray.io.IoWorkerConfig

case class HttpServerConfig(

  // HttpServer
  serverHeader: String = "spray-can/" + SprayCanVersion,

  // IoWorkerConfig
  threadName: String  = IoWorkerConfig.defaultThreadName,
  readBufferSize: Int = IoWorkerConfig.defaultReadBufferSize,

  tcpReceiveBufferSize: Option[Int] = IoWorkerConfig.defaultTcpReceiveBufferSize,
  tcpSendBufferSize: Option[Int] = IoWorkerConfig.defaultTcpSendBufferSize,
  tcpKeepAlive: Option[Boolean] = IoWorkerConfig.defaultTcpKeepAlive,
  tcpNoDelay: Option[Boolean] = IoWorkerConfig.defaultTcpNoDelay,

  // ConnectionTimeoutConfig
  enableConnectionTimeouts: Boolean = true,
  idleTimeout: Duration = Duration("10 sec"),

  // for connection idle and request timeouts
  reapingCycle: Duration = Duration("100 ms"),

  // HttpParserConfig
  maxUriLength: Int             = HttpParserConfig.defaultMaxUriLength,
  maxResponseReasonLength: Int  = HttpParserConfig.defaultMaxResponseReasonLength,
  maxHeaderNameLength: Int      = HttpParserConfig.defaultMaxHeaderNameLength,
  maxHeaderValueLength: Int     = HttpParserConfig.defaultMaxHeaderValueLength,
  maxHeaderCount: Int           = HttpParserConfig.defaultMaxHeaderCount,
  maxContentLength: Int         = HttpParserConfig.defaultMaxContentLength,
  maxChunkExtNameLength: Int    = HttpParserConfig.defaultMaxChunkExtNameLength,
  maxChunkExtValueLength: Int   = HttpParserConfig.defaultMaxChunkExtValueLength,
  maxChunkExtCount: Int         = HttpParserConfig.defaultMaxChunkExtCount,
  maxChunkSize: Int             = HttpParserConfig.defaultMaxChunkSize

) extends IoWorkerConfig with HttpParserConfig
