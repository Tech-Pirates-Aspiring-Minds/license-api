--
-- Table structure for table `licence`
--

CREATE TABLE `licence` (
  `licence_key` varchar(100) NOT NULL,
  `tokens` int(10) NOT NULL,
  `registration` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `expiry` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `licence`
--
ALTER TABLE `licence`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- AUTO_INCREMENT for table `licence`
--
ALTER TABLE `licence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;
